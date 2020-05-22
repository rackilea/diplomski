ChromeDriverService cdservice=new ChromeDriverService.Builder().usingDriverExecutable(new File("/path/to/chromedriver.exe"))
                    .withLogFile(new File("/path/to/chromedriver.log"))
                    .withSilent(true)
                    .usingAnyFreePort()
                    .build();

            WebDriver driver = new ChromeDriver(cdservice);
            driver.get("http://www.google.com");