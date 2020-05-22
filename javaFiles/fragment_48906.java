Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery("explain analyze select * from foo");
while (rs.next())
{
   System.out.println(rs.getString(1));
}