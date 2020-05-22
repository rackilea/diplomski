HashLoginService loginService = new HashLoginService("MyRealm");

UserStore userStore = new UserStore();
userStore.addUser(userName, new Password("password"), new String[] { "users"});

loginService.setUserStore(userStore);