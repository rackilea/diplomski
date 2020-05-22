Columns = [*]
From = Table{xyz}
Where = ("x" = "y")
Group by = ["x"]
Order by = [SortItem{sortKey="y", ordering=ASCENDING, nullOrdering=UNDEFINED}]
Limit = 10