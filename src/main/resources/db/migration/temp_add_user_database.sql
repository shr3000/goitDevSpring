CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

INSERT INTO users (username, password, enabled)
VALUES ('user', '{bcrypt}$2a$10$GGOhG7SHHdqCOeCfQsOH0umt5Hc0gfjI.RMEBTH3gHk6vD6pK95m2', true);