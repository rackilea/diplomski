WebDriver driver = new FirefoxDriver();
driver.get("https://twitter.com/blakeshelton");
WebDriverWait wait = new WebDriverWait(driver, 5);
WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-nav='followers']")));
System.out.println(e.getAttribute("outerHTML"));
System.out.println(e.getAttribute("title"));