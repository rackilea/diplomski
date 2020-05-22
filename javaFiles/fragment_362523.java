public boolean isValidUser(String username , String password){
  WindowsAuthProviderImpl authenticationProvider = new WindowsAuthProviderImpl();
  IWindowsIdentity loggedOnUser = authenticationProvider.logonUser(username, password);
  if(!loggedOnUser.isGuest()){
        return true;
  }
   return false;
 }