public class Configuration {
    public String driver;

    @BeforeTest
    public void cherryPikLaunch() {
        System.out.println("Thread" + Thread.currentThread().getId() + " - cherryPikLaunch");
        driver = "driver";
    }

    @AfterTest
    public void close_browser() {
        System.out.println("Thread" + Thread.currentThread().getId() + " - close_browser");
    }
}

public class CherryPik extends Configuration {
    @Test(priority = 1)
    public void RecentLocation() throws InterruptedException {
        System.out.println("Thread" + Thread.currentThread().getId() + " - RecentLocation - " + driver);
    }

    @Test(priority = 2)
    public void SearchLocation() throws InterruptedException {
        System.out.println("Thread" + Thread.currentThread().getId() +" - SearchLocation - " + driver);
    }

    @Test(priority = 3)
    public void SearchLocationIsExistInTheRecentLocationList() throws InterruptedException {
        System.out.println("Thread" + Thread.currentThread().getId() + " - SearchLocationIsExistInTheRecentLocationList - " + driver);
    }
}

public class ToolsReferralCode extends Configuration {
    @Test(priority = 1)
    public void OpenToolsScreen() {
        System.out.println("Thread" + Thread.currentThread().getId() + " - OpenToolsScreen - " + driver);
    }

    @Test(priority = 2)
    public void OnToolsScreenTitlePresist() {
        System.out.println("Thread" + Thread.currentThread().getId() + " - OnToolsScreenTitlePresist - " + driver);
    }

    @Test(priority = 3)
    public void VerifyThatYourRefferalButtonIsAvailableOnToolsScreen() {
        System.out.println("Thread" + Thread.currentThread().getId()
                + " - VerifyThatYourRefferalButtonIsAvailableOnToolsScreen - " + driver);
    }

    @Test(priority = 4)
    public void OpenYourReferralScreen() {
        System.out.println("Thread" + Thread.currentThread().getId() + " - OpenYourReferralScreen - " + driver);
    }

    @Test(priority = 5)
    public void verifyThatRefferalCodeExistOnRefferalScreen() {
        System.out.println(
                "Thread" + Thread.currentThread().getId() + " - verifyThatRefferalCodeExistOnRefferalScreen - " + driver);
    }
}