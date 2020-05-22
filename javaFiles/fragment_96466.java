SQL> CREATE TABLE PRE1 (
  2           name      VARCHAR2(15),
  3           value      VARCHAR2(15))
  4  /

Table created.

SQL> CREATE TABLE PRE2 (
  2           name      VARCHAR2(15),
  3           value      VARCHAR2(15))
  4  /

Table created.

SQL> CREATE TABLE PRE3 (
  2           name      VARCHAR2(15),
  3           value      VARCHAR2(15))
  4  /

Table created.

SQL> select table_name from user_tables where table_name like 'PRE%';

TABLE_NAME
------------------------------
PRE1
PRE2
PRE3

SQL>