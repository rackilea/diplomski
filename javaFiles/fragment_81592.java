select c.client_id,
  c.object_key,
  c.prio,
  DENSE_RANK() OVER   
    (PARTITION BY c.client_id ORDER BY c.object_key) as sort_idx
from clients as c
order by
  c.prio,
  sort_idx
limit 10;