CREATE TABLE POSTS (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
place VARCHAR(50)
);

insert into POSTS values (1, 'George', 'New York');
insert into POSTS values (2, 'John', 'Colorado');
insert into POSTS values (3, 'Stefi', 'Hawaii');

SELECT * FROM POSTS WHERE id>1 LIMIT 25;