private static class AppiumBasePage {

    public AppiumBasePage() {
    }
}

public class HomePage extends AppiumBasePage {

    LoginPage loginPage;

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

}

public class LoginPage extends AppiumBasePage {

    HomePage homePage;

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }


}

public void test() {
    LoginPage login = new LoginPage();
    HomePage home = new HomePage();
    login.setHomePage(home);
    home.setLoginPage(login);
}