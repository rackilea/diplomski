declare @sql nvarchar(2000);
while(exists(select 1 from sys.objects WHERE type_desc LIKE '%CONSTRAINT%'))
begin
    BEGIN TRY
      SELECT TOP 1 @sql=('ALTER TABLE ' + SCHEMA_NAME(schema_id) + '.[' + OBJECT_NAME(parent_object_id)
      + '] DROP CONSTRAINT [' + OBJECT_NAME(OBJECT_ID) + ']')
      FROM sys.objects
      WHERE type_desc LIKE '%CONSTRAINT%'
      ORDER BY NEWID();
      exec (@sql);
    END TRY
    BEGIN CATCH
    END CATCH
end;
GO