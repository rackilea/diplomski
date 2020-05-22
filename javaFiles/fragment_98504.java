$ psql -q -U postgres postgres
postgres=# CREATE USER nopw;
CREATE ROLE

$ psql -h localhost -U nopw postgres
Password for user nopw:               [pressed enter]
psql: fe_sendauth: no password supplied

$ psql -q -U postgres postgres
postgres=# ALTER USER nopw PASSWORD 'test';
postgres=# \q

$ psql -q -h localhost -U nopw postgres
Password for user nopw:            [entered 'test' then pressed enter]
postgres=>