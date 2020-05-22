select ...
from
    table_name
    inner join
    (values
        (first_value), (second_value)
    ) s(column_name) using (column_name)
;