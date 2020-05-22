ArrayList<String> cliArgsCap = new ArrayList<String>();
cliArgsCap.add("--config=config.json");
DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
capabilities.setCapability(
    PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
capabilities.setCapability("takesScreenshot", false);
capabilities.setCapability(
    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
     "/usr/local/bin/phantomjs");
WebDriver driver = new PhantomJSDriver(capabilities);