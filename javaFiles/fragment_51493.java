rs = con.executeQuery("Select * from tablename");
while(rs.next())
{
   for (String col : columnsList )
   {
     System.out.print(rs.get(col));
   }
   System.out.print("\n");
}