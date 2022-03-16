DROP TABLE IF EXISTS exchange_value;
CREATE TABLE exchange_value (
id INT AUTO_INCREMENT PRIMARY KEY,
currency_from VARCHAR(250) NOT NULL,
currency_to VARCHAR(250) NOT NULL,
conversion_multiple DECIMAL(260) DEFAULT NULL,
port INT(250) NOT NULL
);