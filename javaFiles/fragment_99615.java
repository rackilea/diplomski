public class DashboardSteps extends SuperSteps {
    Drivers context;

    @After
    public void close(Scenario scenario) {
        super.tearDown(scenario);
        loginPage = homePage.clickLogout();
        loginPage.waitPageLoaded();
    }

    public DashboardSteps(Drivers context) {
        super(context);
    }