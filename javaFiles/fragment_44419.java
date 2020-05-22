with MyTable as -------use your table instead of this subquery
(select id, str_to_map(mapStr) mapCol
from
(
select stack(2,
'id1','key1:val1,key2:val2',
'id2','key1:val3,key2:val4'
) as (id, mapStr))s
) -------use your table instead of this subquery

select t.id, s.key, s.val
  from MyTable t
       lateral view outer explode(mapCol) s  as key, val;