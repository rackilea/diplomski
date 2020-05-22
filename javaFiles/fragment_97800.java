// set opera driver location
        System.setProperty("webdriver.opera.driver", "<PATH_TO_operadriver.exe>");
        OperaOptions options = new OperaOptions();
        options.setBinary("<PATH_TO_opera.exe>");
        WebDriver driver = new OperaDriver(options);

        try {
            driver.get("http://amd.com");
            Document doc = Jsoup.parse(driver.getPageSource());
        } finally {
            driver.close();
            driver.quit();
        }