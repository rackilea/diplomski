select col, count(*)
from (select col1 as col from t union all
      select col2 from t union all
      . . . 
      select col30 from t
     ) t
group by col;