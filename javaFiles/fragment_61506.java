select SUM(n) as total
from (
  (select count(*) as n from table1)
  UNION ALL
  (select count(*) as n from table2)
) t;