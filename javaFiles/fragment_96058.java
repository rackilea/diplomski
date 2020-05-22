ALTER SESSION SET nls_comp = Linguistic;
ALTER SESSION SET nls_sort = XGerman_CI;

select *
from my_table
where language_code = 'de'
order by some_column;