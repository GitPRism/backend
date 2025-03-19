CREATE TABLE testmigration (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
