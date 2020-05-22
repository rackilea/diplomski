with recursive ancestry as (
   select child, parent, 1 as level
   from users
   where parent = 'Grandfather' -- this is the one who logs in
   union all
   select c.child, c.parent, p.level + 1
   from users c
     join ancestry p on p.child = c.parent
)
select child, level
from ancestry
order by level desc;