File file = new 
                       File(StackApplication.class.getClassLoader().getResource("driver/chromedriver.exe").getFile());
            String driverPath=file.getAbsolutePath();
            System.out.println("Webdriver is in path: "+driverPath);
            System.setProperty("webdriver.chrome.driver",driverPath);

            WebDriver driver=new ChromeDriver();
            driver.navigate().to("https://340bopais.hrsa.gov/reports");
            driver.findElement(By.xpath("//*[@id=\"headingTwo\"]/h4/a")).click();
            driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_lnkCEDailyReport\"]")).click();



    }