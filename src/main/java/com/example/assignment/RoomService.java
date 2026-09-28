package com.example.assignment;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll(Integer minCapacity, String keyword) {
        return roomRepository.findAll().stream()
                .filter(r -> (minCapacity == null || r.capacity() >= minCapacity))
                .filter(r -> (keyword == null || r.name().toLowerCase().contains(keyword.toLowerCase())))
                .collect(Collectors.toList());
    }

    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    public Room createRoom(Room room) {
        validateCapacity(room.capacity());
        return roomRepository.save(room);
    }

    public Optional<Room> updateRoom(Long id, Room room) {
        validateCapacity(room.capacity());
        Optional<Room> existing = roomRepository.findById(id);
        if (existing.isPresent()) {
            roomRepository.update(id, room);
            return Optional.of(new Room(id, room.name(), room.capacity()));
        }
        return Optional.empty();
    }

    public boolean deleteRoom(Long id) {
        return roomRepository.deleteById(id);
    }

    private void validateCapacity(int capacity) {
        if (capacity < 1 || capacity > 20) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Capacity must be between 1 and 20");
        }
    }
}
