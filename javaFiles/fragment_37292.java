t=# begin;
BEGIN
t=# insert into s values (DEFAULT) returning i;
 i
---
 3
(1 row)

INSERT 0 1
t=# rollback;
ROLLBACK