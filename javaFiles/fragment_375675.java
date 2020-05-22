@Test
public void loginTest(Webdriver driver){
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    loginPage.submit();
    Assert.AssertTrue(dashboardPage.isLoaded());
}