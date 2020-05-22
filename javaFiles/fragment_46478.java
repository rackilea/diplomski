SELECT COUNT( CASE
                  WHEN click_date='2011-06-20' THEN 1
                  ELSE NULL
              END ) AS ThisDayCount
     , COUNT(*) AS ToDayCount
FROM MyTable
WHERE click_date BETWEEN '2011-05-01' AND '2011-06-20' ;