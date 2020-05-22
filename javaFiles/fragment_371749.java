List<User> users=new ArrayList<User>();

while(rs.next()) {
   User user = new User();      
   user.setUserId(rs.getString("UserId"));
   user.setFName(rs.getString("FirstName"));
  ...
  ...
  ...


  users.add(user);
}