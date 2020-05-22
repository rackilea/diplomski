string sql =
   "declare
        user_param user%rowtype;
    begin
        -- Set necessary parameters 
        user_param.col0 := :p0In;
        user_param.col1 := :p1In;
        ...

        -- Call procedure.
        cleansing(io_user => user_param);

        -- Read necessary output values into cursor.
        open :pOut for select user_param.col99 as col99
                              user_param.col98 as col98
                              ...
                       from dual;
    end;"