ChromeOptions chromeOptions = new ChromeOptions();

    ChromeDriver driver = new ChromeDriver(chromeOptions);

    driver.get("https://www.binance.com/de/trade/pro/XRP_BTC");

    WebDriverWait wait = new WebDriverWait(driver, 10);

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='sc-1t2bpae-5 bEXbyP' and contains(text(),'TradingView')]"))).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='sc-1t2bpae-5 bEXbyP' and contains(text(),'Technical Ind')]"))).click();
    WebElement frameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@id, \"tradingview\")]")));
    driver.switchTo().frame(frameElement);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Stochastic RSI')]"))).click();

    WebElement element = driver.findElement(By.className("pane-legend-item-value-wrap"));

    driver.quit();