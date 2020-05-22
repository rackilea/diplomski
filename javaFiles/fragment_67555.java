System.setProperty("webdriver.gecko.driver", "src/geckodriver");
    WebDriver driver = new FirefoxDriver();

    WebDriverWait wait = new WebDriverWait(driver, 30);
    driver.get("http://the-internet.herokuapp.com/");
    driver.findElement(By.xpath("html/body/div[2]/div/ul/li[5]/a")).click();

    By locator = By.xpath("//input[@type='checkbox']");
    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    List<WebElement> elements = driver.findElements(locator);
   int size = elements.size();
    System.out.println(size);