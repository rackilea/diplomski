SQL> declare
  2    l_in_arr  float_array := float_array( 1.1, 2.2, 3.3 );
  3    l_out_arr float_array;
  4  begin
  5    varray_proc( l_in_arr,
  6                 l_out_arr );
  7    for i in 1 .. l_out_arr.count
  8    loop
  9      dbms_output.put_line( l_out_arr(i) );
 10    end loop;
 11  end;
 12  /
2.20000005E+000
4.4000001E+000
6.5999999E+000

PL/SQL procedure successfully completed.