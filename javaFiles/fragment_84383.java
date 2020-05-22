CREATE PROCEDURE [dbo].[Table1sp] AS
BEGIN
    SET NOCOUNT ON;
    SELECT 123;
    CREATE TABLE #Table1 (textcol VARCHAR(50) PRIMARY KEY);
    INSERT INTO #Table1 (textcol) VALUES (NULL);  -- error here
END