-- generate create synonym statements for user objects
DECLARE @FromSchema SYSNAME = 'abc',
        @ToSchema SYSNAME = 'dbo',
        @ServerName SYSNAME = 'server',
        @DatabaseName SYSNAME = 'database';

SELECT  'CREATE SYNONYM ' + QUOTENAME(@ToSchema) + '.' + QUOTENAME(name) +
        ' FOR ' + QUOTENAME(@ServerName) + '.' + QUOTENAME(@DatabaseName) +
        '.' + QUOTENAME(@FromSchema) + '.' + QUOTENAME(name) + ';'
FROM    sys.objects
WHERE   is_ms_shipped = 0;