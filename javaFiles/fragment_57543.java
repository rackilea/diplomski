private void login(String username,String password){
  username.sendKeys(username);
    password.sendKeys(password);

    signInButton.click();
}

public MyHomePage login(String username,String password)
{
    login(username, password);
    return PageFactory.initElements(driver,MyHomePage.class);
}

public LoginPage loginUnsuccessfully(String username,String password)
{
    login(username, password);
    return this;
}