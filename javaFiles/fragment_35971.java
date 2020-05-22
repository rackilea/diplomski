-- if table exists, run query(s); obviously if table does not exist then query(s) is not run

if exists(select 1 from sysobjects where name = 'table-name' and type = 'U')
begin
     execute("select * from table-name")
end