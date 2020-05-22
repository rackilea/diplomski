JSONArray list = new JSONArray();

while (resultSet.next()) {
  JSONObject obj = new JSONObject();       // Move this here.
  // This might be wrong way to make an object for my scenario
  obj.put("FirstName", rs.getString(1));
  obj.put("LastName", rs.getString(2));
  obj.put("Address", rs.getString(3));
  obj.put("Email", rs.getString(4));
  obj.put("PhoneNumber", rs.getString(5));
  list.add(obj);                           // And this here.
}