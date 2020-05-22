@DataProvider
    public static Object[][] loginWrongCreds() {
        Object[][] credentials = new Object[5][2];
        //incorrect login/short login
        credentials[0][0] = "testss"; 
        credentials[0][1] = "testss";
        //empty login
        credentials[1][0] = "";
        credentials[1][1] = "emptylogin";
        //emptypass
        credentials[2][0] = "emptypass"; 
        credentials[2][1] = "";
        //allempty
        credentials[3][0] = "";
        credentials[3][1] = "";
        //incorrect 
        credentials[4][0] = "wrongUname";
        credentials[4][1] = "wrongPass";
        return credentials;
    }