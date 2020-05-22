declare

   l_max_value number;

begin

   select max(id)
     into l_max_value
     from my_table;

   execute immediate 'drop sequence my_sequence_name';

   -- nocache is not recommended if you are inserting more than
   -- one row at a time, or inserting with any speed at all.
   execute immediate 'create sequence my_sequence_name
                           start with ' || l_max_value
                      || ' increment by 1
                           nomaxvalue
                           nocycle
                           nocache';

end;
/