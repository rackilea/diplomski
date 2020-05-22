CREATE TABLE empByRole 
    (id INT, fname TEXT, lname TEXT, role TEXT,
    PRIMARY KEY (role,id)
);

aploetz@cqlsh:stackoverflow> INSERT INTO empByRole (id, fname, lname, role) VALUES (0001,'Angel','Pay','IT Engineer');
aploetz@cqlsh:stackoverflow> SELECT * FROM empByRole WHERE role = 'IT Engineer';

 role        | id | fname | lname
-------------+----+-------+-------
 IT Engineer |  1 | Angel |   Pay

(1 rows)