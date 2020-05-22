class UserDAO{

public void upateUsers(String sql){
   synchronized(UserDAO.class){
    // do update operations
   }
}

public void deleteUser(String sql){
   synchronized(UserDAO.class){
    // do delete operations
   }
}

}