sql = "select * from table1 where ids in (";
for (int i = 0; i < ids.length; i++) 
   if (i == 0)
       sql += "?"
   else 
       sql += ",?";

sql += ")";

PreparedStatement ps = connection.prepareStatement(sql);
for (int i = 0; i < ids.length; i++)
    // replace the XXX with a valid type for UUID, I don't know what type to use
    ps.setXXX(i+1, ids[i]);