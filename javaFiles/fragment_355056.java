-- Table name `account_role` will be translated into `AccountRole`
CREATE TABLE enums.account_role (
    "name" varchar(100) NOT NULL,
    description varchar(255) NOT NULL,
    CONSTRAINT account_role_name_key UNIQUE (name)
);

-- Table entries will be translated into enum entries
INSERT INTO enums.account_role ("name",description) VALUES 
('BILLING','Role for contact/address that will be a Billing contact/address'),
('PAYMENT','Role for contact/address that will be a Payment contact/address'),
('SERVICE','Role for contact/address that will be a Service contact/address'),
('SOLD_TO','Role for contact/address that will be a SoldTo contact/address')
;