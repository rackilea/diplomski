[Test]
public void TestLogin()
{
    // Elements get initialized in the constructor, so you don't have to call it explicitly
    var homePage = new HomePage(Driver);

    var loginPage = homePage.ClickLogin();

    loginPage.Login("username", "password");

    Assert.True(someCondition);
}