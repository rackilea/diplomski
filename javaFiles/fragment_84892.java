set hivevar:start_date=2019-01-02; 
set hivevar:end_date=2019-01-31;  

with date_range as 
(--this query generates date range
select date_add ('${hivevar:start_date}',s.i) as dt, s.i days
  from ( select posexplode(split(space(datediff('${hivevar:end_date}','${hivevar:start_date}')),' ')) as (i,x) ) s
)

select dt, days from date_range;