SQL> set serverout on
SQL> declare
  2    t_mytab  CER_GL_ENTRY_TYPE_LIST := CER_GL_ENTRY_TYPE_LIST();
  3     v_status varchar2(10);
  4  begin
  5
  6    for idx in 1..10 loop
  7      t_mytab.extend;
  8      t_mytab(t_mytab.last) := CER_GL_ENTRY_TYPE(idx, 'x', 'x', 0, 1, 'x', 1, 1, 1, 1, 1, 1, 'x', 1, 1, 1, 1, 'x', 'x', 2, 'foo');
  9    end loop;
 10
 11    GL_PROCESS_BULK_ENTRIES(t_mytab, v_status);
 12
 13  end;
 14  /
1
2
3
4
5
6
7
8
9
10
10
true

PL/SQL procedure successfully completed.