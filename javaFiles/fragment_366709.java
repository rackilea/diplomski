create table Client (
    cid NUMBER PRIMARY KEY,
    fname VARCHAR2(255) NOT NULL,
    lname VARCHAR2(255) NOT NULL,
    email VARCHAR2(255),
    phone VARCHAR2(255),
    address VARCHAR(255) NOT NULL,
   age number NOT NULL
);