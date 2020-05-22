begin
  for data_1 in (select f2.col1, f2.col2 from foo_2 f2
                 where f2.id in (select f1.id from foo_1 f1)) loop

     ... do something

  end loop;
end;
/