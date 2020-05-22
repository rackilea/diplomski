IF OBJECT_ID('test') IS NOT NULL
DROP TABLE test;

CREATE TABLE test(
spalte1 int PRIMARY KEY NOT NULL);

INSERT INTO test
SELECT top 1000 row_number() over (order by (select 0)) FROM sys.columns as sys1 
cross join sys.columns as sys2