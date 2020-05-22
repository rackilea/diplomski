SET @sql = NULL;
SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT(
      'GROUP_CONCAT(case when branch = ''',
      branch,
      ''' then status ELSE NULL end) AS ',
      CONCAT('Branch',branch)
    )
  ) INTO @sql
FROM Table1;

SET @sql = CONCAT('SELECT productName, ', @sql, ' 
                   FROM Table1 
                   GROUP BY productName');


PREPARE stmt FROM @sql;
EXECUTE stmt;