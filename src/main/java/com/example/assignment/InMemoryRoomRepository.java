package com.example.assignment;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryRoomRepository implements RoomRepository {

    private final List<Room> rooms = new ArrayList<>(List.of(
            new Room(1L, "Seminar A", 8),
            new Room(2L, "Study Pod", 4),
            new Room(3L, "Rooftop Room", 12)));

    private final AtomicLong nextId = new AtomicLong(4);

    @Override
    public List<Room> findAll() {
        return new ArrayList<>(rooms);
    }

    @Override
    public Optional<Room> findById(Long id) {
        return rooms.stream()
                .filter(r -> r.id().equals(id))
                .findFirst();
    }

    @Override
    public Room save(Room room) {
        Room newRoom = new Room(nextId.getAndIncrement(), room.name(), room.capacity());
        rooms.add(newRoom);
        return newRoom;
    }

    @Override
    public void update(Long id, Room room) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).id().equals(id)) {
                rooms.set(i, new Room(id, room.name(), room.capacity()));
                return;
            }
        }
    }

    @Override
    public boolean deleteById(Long id) {
        return rooms.removeIf(r -> r.id().equals(id));
    }
}
