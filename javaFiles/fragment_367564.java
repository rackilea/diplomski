java.sql.ResultSet rslt= stmt.executeQuery(
"select name from student natural join takes t1 where (dept_name='Comp. Sci.') "+
"group by ID "+
"order by (select avg( case grade "+
        "when 'A+' then 4  "+
    "when 'A' then 4 "+
    "when 'A-' then 3.7 "+
    "when 'B+' then 3.5 "+
    "when 'B' then 3 "+
    "when 'B-' then 2.7 "+
    "when 'C+' then 2.5 "+
    "when 'C' then 2 "+
    "when 'C-' then 1 "+
    "end) as avg_gpa "+
    "from takes t2 "+
"where t1.ID=t2.ID) "+
"limit 10");