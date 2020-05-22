with recursive cat_tree as (
   select category_id, parent_id, name, array[category_id] as sort, category_id::text as path
   from category
   where parent_id is null
   union all
   select c.category_id, c.parent_id, c.name, p.sort||c.category_id, p.path||'.'||c.category_id
   from category c
     join cat_tree p on p.category_id = c.parent_id
)
select category_id, parent_id, path, name
from cat_tree
order by sort;