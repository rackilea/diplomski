ArrayList<String> cols = new ArrayList<String>();
while(rs.next())
  {
    cols.add(rs.getString(1));
    // Do something..
  }