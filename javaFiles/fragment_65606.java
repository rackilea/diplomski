SQL> select * from xx;

no rows selected

SQL> insert into xx values ('x');

1 row created.

SQL> alter sequence so_test increment by 100;

Sequence altered.

SQL> rollback;

Rollback complete.

SQL> select * from xx;

Y
-----
x

SQL>