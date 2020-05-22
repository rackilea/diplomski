select *
from (
   select book_id, author_id, mark, year, 
          row_number() over (partition by author_id order by case mark when 'GREAT' then 1 when 'MEDIUM' then 2 else 3 end) as rn
   from books
) t
where rn = 1;