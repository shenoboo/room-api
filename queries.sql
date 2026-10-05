-- Q1. Rooms for 6 or more people, largest first.
SELECT * FROM room WHERE capacity >= 6 ORDER BY capacity DESC;

-- Q2. Every reservation made by Mina.
SELECT * FROM reservation WHERE name = 'Mina';

-- Q3. Every reservation with the name of its room.
SELECT reservation.*, room.name AS room_name FROM reservation JOIN room ON reservation.room_id = room.id;

-- Q4. Reservations for Seminar A on 6 October 2026.
SELECT reservation.* FROM reservation JOIN room ON reservation.room_id = room.id WHERE room.name = 'Seminar A' AND reservation.date = '2026-10-06';

-- Q5. Number of reservations per room (JOIN).
SELECT room.name, COUNT(reservation.id) AS reservation_count FROM room JOIN reservation ON room.id = reservation.room_id GROUP BY room.id;

-- Q6. Same as Q5, but show 0 for rooms with no reservations.
SELECT room.name, COUNT(reservation.id) AS reservation_count FROM room LEFT JOIN reservation ON room.id = reservation.room_id GROUP BY room.id;

-- Q7. Rooms that have never been reserved.
SELECT room.* FROM room LEFT JOIN reservation ON room.id = reservation.room_id WHERE reservation.id IS NULL;

-- Q8. Rooms with more than two reservations.
SELECT room.name FROM room JOIN reservation ON room.id = reservation.room_id GROUP BY room.id HAVING COUNT(reservation.id) > 2;

-- Challenge. Which reservations in room 1 overlap 10:30–11:30 on 6 October 2026?
SELECT reservation.* FROM reservation JOIN room ON reservation.room_id = room.id 
WHERE room.name = 'Room 1' AND reservation.date = '2026-10-06' 
AND reservation.start_time < '11:30:00' AND reservation.end_time > '10:30:00';
