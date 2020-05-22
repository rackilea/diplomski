public static User registerUser(String firstname, String lastname, String 
  username, String password) {
      User myUser = new User(firstname, lastname, username, password);
      userList.add(myUser);
      return myUser;
      }