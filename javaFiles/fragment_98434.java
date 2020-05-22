BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(); // can specify a port here if you like

        // get the selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // if chromedriver isn't on your system path, you'll need to set this system property
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver(capabilities);

        driver.get("https://www.google.com/");