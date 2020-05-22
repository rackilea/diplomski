@Test
void loginTest() {

  // Create instance of LoginHelper.
  LoginHelper loginHelper = new LoginHelper(driver);

  // Login to your application.
  loginHelper.loginAssertUser();
}