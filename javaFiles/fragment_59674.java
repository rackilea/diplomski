CREATE VIEW "test" AS 
    SELECT id, size AS 'S', calories AS 'C',
    size/100.0 AS 'S/100',
    calories * (size/100.0) AS 'C*(S/100)', 
    100 + (calories * (size/100.0)) AS '100+(C*(S/100))',
    CASE WHEN (300 > (100 + (calories * (size/100.0)))) 
        THEN 'true' ELSE 'false' END AS 'Eq'
    FROM allfoods;