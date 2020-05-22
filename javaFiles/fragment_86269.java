SQL>
SQL> declare
  2
  3     l_max_id number;
  4     l_max_seq number;
  5
  6  begin
  7
  8     -- Get the maximum ID
  9     select max(id) into l_max_id
 10       from tmp_test;
 11
 12     -- Get the current sequence value;
 13     select test_seq.currval into l_max_seq
 14       from dual;
 15
 16     -- Alter the sequence to increment by the difference ( -5 in this case )
.
 17     execute immediate 'alter sequence test_seq
 18                          increment by ' || ( l_max_id - l_max_seq );
 19
 20     -- 'increment' by -5
 21     select test_seq.nextval into l_max_seq
 22       from dual;
 23
 24     -- Change the sequence back to normal
 25     execute immediate 'alter sequence test_seq
 26                          increment by 1';
 27
 28  end;
 29  /

PL/SQL procedure successfully completed.

SQL>
SQL> select test_seq.currval from dual;

   CURRVAL
----------
        15

SQL>