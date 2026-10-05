CREATE TABLE room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    capacity INT CHECK (capacity >= 1 AND capacity <= 20)
);

CREATE TABLE reservation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT NOT NULL,
    reserved_by VARCHAR(255) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (room_id) REFERENCES room(id)
);
