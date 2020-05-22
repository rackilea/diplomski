CREATE TABLE activity_count_table(activity_type, activity_count);

INSERT INTO activity_count_table 
    SELECT activity_type, COUNT(activity_type) AS activity_count
    FROM table_name
    WHERE date_time BETWEEN 10 AND 100
    GROUP BY activity_type;

SELECT * 
FROM table_name NATURAL JOIN activity_count_table
WHERE date_time BETWEEN 10 AND 100
ORDER BY activity_count_table.activity_count DESC;

DROP TABLE activity_count_table;