ResultSet rs=db.runQuery(query) // I don't know where this function is coming from, but okay
while (rs.next())
{
  String myColumn=rs.getString("column_name");
  System.out.println(myColumn);
}
rs.close();