create type float_array
    is varray(3) of binary_float;
/

create table foo (
  col1 number
);
/

create or replace procedure varray_proc( p_in_arr   in float_array,
                                         p_out_arr out float_array )
as
begin
  for i in 1 .. p_in_arr.count
  loop
    insert into foo( col1 )
      values( p_in_arr(i) );
  end loop;
  select col1*2
    bulk collect into p_out_arr
    from foo;
end;
/