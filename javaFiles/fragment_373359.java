WITH x AS (
   SELECT folder_id, name
   FROM   folders
   WHERE  folder_id = $1;
   )
SELECT * FROM x
UNION  ALL
SELECT $1, NULL
WHERE  NOT EXISTS (SELECT 1 FROM x);