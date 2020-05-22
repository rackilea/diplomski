CREATE TABLE customer (
    id INT NOT NULL,
    -- other columns...
    PRIMARY KEY(id)
);

CREATE TABLE address (
    id INT NOT NULL,
    addressType INT NOT NULL,
    customer_id INT NOT NULL,
    addressLine1 VARCHAR(200) NOT NULL,
    -- other columns...
    PRIMARY KEY(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);