ALTER SESSION SET nls_comp = Linguistic;
ALTER SESSION SET nls_sort = XFrench_AI;

select *
from my_table
where language_code = 'fr'
order by some_column;