public static void searchGoogle(String query) throws InterruptedException {
    try {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.co.uk");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("\"" + query + "\" filetype:pdf\n");
        element.submit();

        // wait until the google page shows the result
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

        getResults(driver);
        Thread.sleep(1000);

        for (int i = 0; i < 10; i++) {
            driver.findElement(By.linkText("Next")).click();
            Thread.sleep(1000);
            getResults(driver);
        }
    } catch (Exception e) {
        System.err.println("Error caught - " + e);
    }

}

public static void getResults(WebDriver driver) {
    List<WebElement> findElements = null;
    findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

    for (WebElement webElement : findElements) {
        System.out.println(webElement.getAttribute("href"));
    }
}