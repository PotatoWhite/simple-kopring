CREATE TABLE IF NOT EXISTS account
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    date_of_birth DATE         NOT NULL
);