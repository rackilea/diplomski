ResultSet rs = stmt.executeQuery(sql);
int count = -1;
if (rs.next())
{
  count = rs.getInt(1);
}