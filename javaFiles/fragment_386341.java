System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
WebDriver driver=new FirefoxDriver();
driver.get("http://jqueryui.com/resizable/");
driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
WebElement  target = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")));
//dragAndDropBy(WebElement source, int xOffset, int yOffset) //status: WORKS
new Actions(driver).dragAndDropBy(target, 50, 50).build().perform();
System.out.println("Resizing of element Completed");