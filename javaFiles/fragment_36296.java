public void testPhantomDriver() throws Exception {
    DesiredCapabilities options = new DesiredCapabilities();
    // the website i am scraping uses ssl, but I dont know what version
    options.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
          "--ssl-protocol=any"
      });

    PhantomJSDriver driver = new PhantomJSDriver(options);

    driver.get("https://www.mywebsite");

    List<WebElement> elements = driver.findElementsByClassName("media-title");

    for(WebElement element : elements ){
        System.out.println(element.getText());
    }

    driver.quit();
}