begin
  for data_1 in (select id from foo_1) loop
    dbms_output.put_line(to_char(data_1.id));

    for data_2 in (select f2.col1, f2.col2 from foo_2 f2 where f2.id = data_1.id) loop
        ... do something else
    end loop;

  end loop;
end;
/