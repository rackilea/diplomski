# application specific code; I don't work with java but the gist of the operation would be ...
run-query-in-db("select 1 from sysobjects where name = 'table-name' and type = 'U'")
if-query-returns-a-row
then
    run-query-in-db("select * from table-name")
fi