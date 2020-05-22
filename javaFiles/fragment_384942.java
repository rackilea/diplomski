create type float_nt
    is table of binary_float;

create or replace procedure varray_proc( p_in_arr   in float_nt,
                                         p_out_arr out float_nt )
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