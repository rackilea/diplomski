String sql = "select f2.col1, f2.col2 from foo_2 f2 where f2.id in (select f1.id from foo_1 f1)";
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(sql);
while (rs.next())
{
   String col1_value = rs.getString(1);
   int    col2_value = rs.getInt(2);
   ... do something
}