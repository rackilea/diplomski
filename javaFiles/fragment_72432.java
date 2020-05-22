CREATE TABLE status (
  id INTEGER PRIMARY KEY,
  description VARCHAR(40)
)

CREATE TABLE entity (
 ...
 status_id INTEGER REFERENCES status(id)
)

INSERT INTO status VALUES (0,'Closed');
INSERT INTO status VALUES (1,'Open');
INSERT INTO status VALUES (2,'Broken - replacement has been ordered');