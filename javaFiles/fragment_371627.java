myMethod() {
    //Before running the external Command
    MySecurityManager secManager = new MySecurityManager();
    System.setSecurityManager(secManager);

    try {
       invokeExternal();
    } catch (SecurityException e) {
       //Do something if the external code used System.exit()
    }
}