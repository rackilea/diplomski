select c1.client_id,
  c1.object_key,
  c1.prio,
  count(*)-1 as sort_idx
from clients as c1
  left join clients as c2
    on c1.client_id = c2.client_id
      and c1.object_key >= c2.object_key
      and c1.prio >= c2.prio
group by c1.client_id,
        c1.object_key,
        c1.prio
order by
  c1.prio,
  sort_idx
limit 10;