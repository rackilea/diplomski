public WebDriver appiumCapabilities() {
    File appDir = new File(System.getProperty("user.dir"), "/app/");
    File app = new File(appDir, "test.app");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
    capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability("deviceName", "iPod");
    capabilities.setCapability("platformVersion", "7.1");
    capabilities.setCapability("device", "iphone");
    capabilities.setCapability("udid", "cd827d3778cfdee2fc7210f8f44184821a083c06");
    capabilities.setCapability("app", app);

    try {
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    return driver;
}