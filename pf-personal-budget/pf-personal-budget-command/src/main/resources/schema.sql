DROP TABLE IF EXISTS cash_flow;
CREATE TABLE `cash_flow` (
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    amount DECIMAL NOT NULL,
    description VARCHAR(255) DEFAULT NULL,
    creation_date_time DATETIME NOT NULL,
    type VARCHAR(30) NOT NULL,
    currency VARCHAR(20) NOT NULL,
    category VARCHAR(60) DEFAULT NULL
);