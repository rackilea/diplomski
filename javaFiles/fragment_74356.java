set serveroutput on; -- for debugging, 
-- it makes sense if your procedure outputs anything
declare my_list TableOfMyObject  := TableOfMyObject ();
begin 
  my_list.extend;
  my_list(1) := MyType([MyType constructor parameters]);

  my_list.extend;
  my_list(2) := MyType([MyType constructor parameters]);
  your_procedure(my_list);
end;