USE tempdb;
GO
-- create test schema
CREATE SCHEMA test AUTHORIZATION dbo;
GO

-- create table in test schema
CREATE TABLE test.tablename (columnname int null);

-- select from tablename in default schema will fail
SELECT * FROM tablename;
GO

-- create synonym mapping test.tablename to dbo.tablename
CREATE SYNONYM [dbo].[tablename] FOR [server].[tempdb].[test].[tablename]

-- -- select from tablename synonym will succeed
SELECT * FROM tablename;

-- cleanup
DROP SYNONYM [dbo].[tablename];
DROP TABLE [test].[tablename];
DROP SCHEMA [test];