select event, sum(round(time_waited/(100*60),2)) time_mins, wait_class
from v$session_event
where sid in (221)
group by event, wait_class
order by 2 desc;

select sid, name, value from v$sesstat s 
  join v$statname n on n.statistic# = s.statistic#
where s.sid in (221)
and name in ('consistent gets','sorts (rows)','execute count',
        'parse count (total)','user calls','user commits','user rollbacks'
order by value desc;