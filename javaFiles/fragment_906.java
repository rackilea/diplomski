ResultSetMetaData meta = crs.getMetaData();
 int numCol = meta.getColumnCount();

for (int i = 1; i < numCol+1; i++) 
{
    if(meta.getColumnName(i).equals("name"))
    {return true;}

}
return false;