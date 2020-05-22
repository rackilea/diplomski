@Test(dataprovider="User") 
    public static void login_with_valid_username_and_valid_password(String username, String password){

        Login_action.Login_to_application(username,password);
        Login_action.pressSubmitButton();

        Assert.assertEquals(StatApplication.driver.getTitle(), "Home");

        StatApplication.driver.close();
    }




    @DataProvider(name="User")
        public Object[][] getDataFromDataprovider(){
        return new Object[][] 
            {
                { "User1", "asd" },
                { "User2", "asdd" },
                { "User3", "asds" }, { "User4", "asds" }, { "User5", "asds" }
            };