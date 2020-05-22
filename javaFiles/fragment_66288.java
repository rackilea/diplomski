//...
List<User> users = new ArrayList<User>();
//...
while(rs.next())
    {
        user  = new User();
        user.setId(rs.getInt(1));
        user.setName(rs.getString(2));
        user.setDepartament(rs.getString(3));
        user.setPassword(rs.getString(4));
        users.add(user);
    }