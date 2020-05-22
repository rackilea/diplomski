SELECT p.periodOfDay, COUNT(j.periodOfDay),
       SUM(CASE WHEN j.range_1 < 36 AND j.range_2 < 18 THEN 1 ELSE 0 END),
       SUM(CASE WHEN j.range_1 > 36 AND j.range_1 < 100 AND range_2 > 18 AND range_2 < 100 THEN 1 ELSE 0 END),
       SUM(CASE WHEN j.range_1 > 100 AND j.range_2 > 100 THEN 1 ELSE 0 END)
FROM (SELECT 1 as periodOfDay UNION ALL
      SELECT 2 as periodOfDay UNION ALL
      SELECT 3 as periodOfDay
     ) p LEFT JOIN
     tb_journal j
     ON p.periodOfDay = j.periodOfDay
GROUP BY p.periodOfDay;