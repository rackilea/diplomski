CREATE TABLE customer (
    id INT NOT NULL,
    billingAddressLine1 VARCHAR(200) NOT NULL,
    shippingAddressLine1 VARCHAR(200) NOT NULL,
    -- other columns...
    PRIMARY KEY(id)
);