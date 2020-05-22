@Test
public void verifyFacebookTitle()
{
    DesiredCapabilities caps = new DesiredCapabilities();
    ((DesiredCapabilities) caps).setJavascriptEnabled(true);
    ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
    ((DesiredCapabilities) caps).setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Utility\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
    caps.setJavascriptEnabled(true);
    String [] phantomJsArgs = {"--web-security=no", "--ignore-ssl-errors=yes"};
    caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
    WebDriver driver = new PhantomJSDriver(caps);
    driver.get("https://www.facebook.com/");
    System.out.println(driver.getTitle());
    driver.quit();
}