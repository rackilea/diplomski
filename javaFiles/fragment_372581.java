SET @FROM_STR = 's1';
SET @TO_STR = 's3';

SELECT * 
FROM   food_name
JOIN (
  SELECT 
  CASE WHEN concat('',SUBSTR(@FROM_STR, 2) * 1) = SUBSTR(@FROM_STR, 2) THEN
    CAST(SUBSTR(@FROM_STR, 2) AS SIGNED)
  ELSE
    NULL
  END
  AS FROM_NUM,  
  CASE WHEN concat('',SUBSTR(@TO_STR, 2) * 1) = SUBSTR(@TO_STR, 2) THEN
    CAST(SUBSTR(@TO_STR, 2) AS SIGNED)
  ELSE
    NULL
  END
  AS TO_NUM

  FROM DUAL
     ) PARAMS
WHERE BINARY food_name between @FROM_STR and @TO_STR AND (
  (food_name NOT LIKE 's%') OR 
  (
    concat('',SUBSTR(food_name, 2) * 1) = SUBSTR(food_name, 2) -- is 's' + number
    AND
    CAST(SUBSTR(food_name, 2) AS SIGNED) BETWEEN PARAMS.FROM_NUM AND PARAMS.TO_NUM
  )
);