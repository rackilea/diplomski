public final class SetUpDriver {

    private SetUpDriver() {
        // Hide the constructor.
    }

    public static AndroidDriver<MobileElement> getMobileDriver(String type) throws MalformedURLException {
        switch (type) {
        case "1":
            return emulatorDevice5554();
        case "2":
            return emulatorDevice5556();
        default:
            throw new IllegalArgumentException();
        }
    }

    private static AndroidDriver<MobileElement> emulatorDevice5554() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = getCommonCapabilities();
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("platformVersion", "8.1.0");
        desiredCapabilities.setCapability("systemPort", "8201");

        // initialize mobileDriver
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
                desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

    private static AndroidDriver<MobileElement> emulatorDevice5556() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = getCommonCapabilities();
        desiredCapabilities.setCapability("deviceName", "emulator-5556");
        desiredCapabilities.setCapability("platformVersion", "7.0");
        desiredCapabilities.setCapability("systemPort", "8202");

        // initialize mobileDriver
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:5000/wd/hub"),
                desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

    private static DesiredCapabilities getCommonCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("app", "C:/Users/Asus/IdeaProjects/iopayphonex/app/app.apk");
        desiredCapabilities.setCapability("appPackage", "package");
        desiredCapabilities.setCapability("appActivity", "Activity");
        desiredCapabilities.setCapability("noReset", true);
        return desiredCapabilities;
    }
}