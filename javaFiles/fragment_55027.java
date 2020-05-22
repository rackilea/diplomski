insert into target_table(id, col_1, col_2)
select id, col_1, col_2
from staging_table 
where not exists (select *
                  from target_table 
                  where target_table.id = staging_table.id);