select a.*,
       b.next_time
from   statusupdates as a
       left join
       (
       select a.fullname,
              a.time,
              min( b.time ) as next_time
       from   statusupdates as a
              left join
              statusupdates as b
              on a.fullname = b.fullname
              and a.time < b.time
       group by a.fullname,
              a.time
       ) as b
       on a.fullname = b.fullname
       and a.time = b.time
;