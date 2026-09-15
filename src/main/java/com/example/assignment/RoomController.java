package com.example.assignment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final List<Room> rooms = new ArrayList<>(List.of(
            new Room(1L, "Seminar A", 8),
            new Room(2L, "Study Pod", 4),
            new Room(3L, "Rooftop Room", 12)));

    private final AtomicLong nextId = new AtomicLong(4);

    @GetMapping
    public List<Room> getAllRooms() {
        return rooms;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        return rooms.stream()
                .filter(r -> r.id().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createRoom(@RequestBody RoomCreateRequest request) {
        Room newRoom = new Room(nextId.getAndIncrement(), request.name(), request.capacity());
        rooms.add(newRoom);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newRoom.id())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody RoomCreateRequest request) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).id().equals(id)) {
                Room updatedRoom = new Room(id, request.name(), request.capacity());
                rooms.set(i, updatedRoom);
                return ResponseEntity.ok(updatedRoom);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        boolean removed = rooms.removeIf(r -> r.id().equals(id));
        if (removed) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}