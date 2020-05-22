SQL> create sequence test_seq
  2   start with 1
  3   increment by 1
  4   nomaxvalue
  5   nocycle
  6   nocache;

Sequence created.

SQL>
SQL> create table tmp_test ( id number(16) );

Table created.

SQL>
SQL> declare
  2     l_nextval number;
  3  begin
  4
  5    for i in 1 .. 20 loop
  6       insert into tmp_test values ( test_seq.nextval );
  7    end loop;
  8
  9  end;
 10  /

PL/SQL procedure successfully completed.

SQL>
SQL> select test_seq.currval from dual;

   CURRVAL
----------
        20

SQL>
SQL> delete from tmp_test where id > 15;

5 rows deleted.

SQL> commit;

Commit complete.