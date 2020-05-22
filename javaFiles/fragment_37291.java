t=# create table s(i serial);
CREATE TABLE
t=# insert into s values (DEFAULT);
INSERT 0 1
t=# insert into s values (DEFAULT) returning i;;
 i
---
 2
(1 row)

INSERT 0 1