SQL> declare
  2    t_mytab  CER_GL_ENTRY_TYPE_LIST := CER_GL_ENTRY_TYPE_LIST();
  3     v_status varchar2(10);
  4  begin
  5
  6    t_mytab := CER_GL_ENTRY_TYPE_LIST(
  7                CER_GL_ENTRY_TYPE(123, 'x', 'x', 0, 1, 'x', 1, 1, 1, 1, 1, 1, 'x', 1, 1, 1, 1, 'x', 'x', 2, 'foo'),
  8                CER_GL_ENTRY_TYPE(2, 'x', 'x', 0, 1, 'x', 1, 1, 1, 1, 1, 1, 'x', 1, 1, 1, 1, 'x', 'x', 2, 'foo')
  9              );
 10
 11    GL_PROCESS_BULK_ENTRIES(t_mytab, v_status);
 12
 13  end;
 14  /
123
2
2
true