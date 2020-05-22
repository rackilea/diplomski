DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
    ieCapabilities.setCapability("requireWindowFocus", true);   
    ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
    ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
    ieCapabilities.setCapability("disable-popup-blocking", true);
    ieCapabilities.setCapability("enablePersistentHover", true);*/
    System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
    WebDriver driver = new InternetExplorerDriver(ieCapabilities);