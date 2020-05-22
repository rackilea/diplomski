public String createUser(String username, String password, SomeApiListener listener) {

    someApi.do(config -> {
        //code here with respect to someApi.

        //somewhere here you are creating a TestListener ?, 
        //well... don't, and use the one passed from caller (listener)
    });
}