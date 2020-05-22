public static void login(String fbUser){
    String userName = fbUser.split("/")[0]; //get UserName from fbUser
    String password = fbUser.split("/")[1]; //get Password from fbUser
    fbUsers.remove(fbUser); //remove the fbUser with which we have logged in

    //code to login
  }