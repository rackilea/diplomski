ResultSet rs = stmt.executeQuery(sql);
if (rs.next())
{
  Upravljanje upravljanje = new Upravljanje(rs.getInt("max"), rs.getInt("now"), rs.getInt("cijenaH"));
  ...
}