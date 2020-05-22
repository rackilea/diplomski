public class SharedDriver {
    public SharedDriver() {
        if (DriverFactory.getDriver() == null) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        DriverFactory.addDriver(new ChromeDriver());
    }
    }   
}