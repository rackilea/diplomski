CREATE OR REPLACE VIEW mission_derived AS
select 
  m.`id` as id,
  min(t.`time`) as startDate
from `trip` t
inner join `mission` m on t.`mission_id` = m.`id`
group by m.`id`;