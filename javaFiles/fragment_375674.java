@Test
public void test(){
    Webdriver driver = new Chromedriver();//For expample I'm using Chromedriver
    driver.get("YourTestAppilcationURL");
    LoginPage loginPage = new LoginPage(driver);
    loginPage.un.sendKeys("username");
    loginPage.pwd.sendKeys("password");
    DashboardPage dashboardPage = loginPage.submit();
//Now perform tasks in the dashboardPage
}