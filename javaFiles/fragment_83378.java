int indexForLastName = cur.getColumnIndex("Last_Name");
while(cur.next()) {
  Row row = cur.getRow()
  String lastname = row.getString(indexForLastName);
  //more stuff
}