create table bar (
  col1     number, 
  order_by number
);

create or replace procedure varray_proc( p_in_arr   in float_nt,
                                         p_out_arr out float_nt )
as
begin
  for i in 1 .. p_in_arr.count
  loop
    insert into bar( col1, order_by )
      values( p_in_arr(i), i );
  end loop;
  select col1*2
    bulk collect into p_out_arr
    from bar
   order by order_by;
end;
/