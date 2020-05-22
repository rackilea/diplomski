@Test
    public void sTest () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techbeamers.com/handling-html-tables-selenium-webdriver/");
        List<WebElement> el = driver.findElements(By.xpath("//*[@id='post-3500']/div[1]/div/p[3]/a"));
        el.forEach((e)-> {
            if(!e.getText().equals(expectedString)) throwError
        });
        driver.quit();

    }