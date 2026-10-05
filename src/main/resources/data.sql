INSERT INTO room (name, capacity) VALUES ('Seminar A', 20);
INSERT INTO room (name, capacity) VALUES ('Seminar B', 10);
INSERT INTO room (name, capacity) VALUES ('Room 1', 6);

INSERT INTO reservation (room_id, name, date, start_time, end_time) VALUES (1, 'Mina', '2026-10-06', '09:00:00', '11:00:00');
INSERT INTO reservation (room_id, name, date, start_time, end_time) VALUES (1, 'John', '2026-10-06', '13:00:00', '14:00:00');
INSERT INTO reservation (room_id, name, date, start_time, end_time) VALUES (3, 'Mina', '2026-10-06', '10:00:00', '11:00:00');
INSERT INTO reservation (room_id, name, date, start_time, end_time) VALUES (3, 'Alice', '2026-10-06', '11:00:00', '12:00:00');
INSERT INTO reservation (room_id, name, date, start_time, end_time) VALUES (3, 'Bob', '2026-10-07', '10:00:00', '11:00:00');
