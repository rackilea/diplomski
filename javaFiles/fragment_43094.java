select 2.*
from device_registration d
where not exists (select 1
                  from device_registration d2
                  where d2.push_token = d.push_token and d2.registration_date > d.registration_date
                 )
order by d.registration_date desc;