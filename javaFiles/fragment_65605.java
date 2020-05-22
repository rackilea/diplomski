SQL> create sequence so_test start with 100 increment by 100 nocache;

Sequence created.

SQL> select so_test.nextval - 99 as first_seq, so_test.currval as last_seq from dual;

 FIRST_SEQ   LAST_SEQ
---------- ----------
         1        100

SQL> /

 FIRST_SEQ   LAST_SEQ
---------- ----------
       101        200

SQL> /

 FIRST_SEQ   LAST_SEQ
---------- ----------
       201        300

SQL>