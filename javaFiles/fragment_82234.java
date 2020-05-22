rs = stmt.executeQuery(sql);
while (rs.next()) 
{
    List<String> list = new ArrayList<String>();
    list.add(rs.getString(2));
    list.add(rs.getString(3));
    ref.put(rs.getString(1), list);
}