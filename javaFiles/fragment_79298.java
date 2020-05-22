select *
from (
  select personid, 
         reportto_personid, 
         level as lvl
  from the_table
  start with personid = 2
  connect by prior personid = reportto_personid
) t 
where lvl <= 2;