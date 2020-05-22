public class SingltonFactory{

    private static SingltonFactory instance = new SingltonFactory();
    private static AppiumDriver<MobileElement> driver;

    private SingltonFactory() {
    }

    // Get the only object available
    public static SingltonFactory getInstance() {
        return instance;
    }

    // Get the only object available
    public void setDriver(AppiumDriver<MobileElement> driver1) {
        driver = driver1;
    }

    public AppiumDriver<MobileElement> getAppiumDriver() {
        return driver;
    }