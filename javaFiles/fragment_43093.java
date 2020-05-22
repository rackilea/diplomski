select d2.user_id, d2.push_token, d2.registration_date
from device_registration d2 join
     (select max(d1.registration_date) as registration_date, d1.push_token
      from device_registration d1
      where d1.push_Token <> 'null' and d1.push_Token is not null and d1.push_Token <> ''
      group by d1.push_token
     ) d3
     on d2.push_token = d3.push_token and d2.registration_date = d3.registration_date 
order by d2.registration_date asc;