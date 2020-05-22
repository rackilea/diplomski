ArrayList<String> cliArgsCap = new ArrayList<String>();
cliArgsCap.add("--proxy=address:port");
cliArgsCap.add("--proxy-auth=username:password");
cliArgsCap.add("--proxy-type=http");
DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
capabilities.setCapability(
    PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
WebDriver driver = new PhantomJSDriver(capabilities);