SELECT
    b.date,
    COUNT(CASE WHEN some_col = 'some_value' THEN 1 END) AS cnt
FROM table_b b
WHERE b.user = 'user1' AND b.date BETWEEN '2019-07-21' AND '2019-07-26' 
GROUP BY b.date;