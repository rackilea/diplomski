SQL> SELECT Name FROM CollationTestTable WHERE NAME LIKE '%pe%';

NAME
--------------------------------------------------------------------------------
pepe

SQL> alter session set nls_sort=Latin_AI;

Session altered

SQL> alter session set nls_comp=linguistic;

Session altered

SQL> SELECT Name FROM CollationTestTable WHERE NAME LIKE '%pe%';

NAME
--------------------------------------------------------------------------------
pepe
pépé
PEPE