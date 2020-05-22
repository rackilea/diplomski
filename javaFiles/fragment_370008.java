List ll = new LinkedList();
ResultSet rs = stmt.executeQuery("SELECT userid, username FROM USER");

// Fetch each row from the result set
while (rs.next()) {
  int i = rs.getInt("userid");
  String str = rs.getString("username");

  //Assuming you have a user object
  User user = new User(i, str);

  ll.add(user);
}