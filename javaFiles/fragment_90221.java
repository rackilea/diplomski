public User login(String userName, String pwd){
    User actual = null;
   if(users!=null){
    for (User me : users) {
        if (me.checkLogin(userName, pwd)){
            actual = me;
        }
    }
    return actual;

   }

   return null; 
   }