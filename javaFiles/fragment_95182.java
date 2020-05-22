select ...
from
    table_name
    inner join
    unnest(
        array[first_value, second_value]
    ) s(column_name) using (column_name)
;