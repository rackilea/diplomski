Actions builder = new Actions(driver);
    Action mouseOverMenu;

    mouseOverMenu = builder.moveToElement(driver.findElement(By.id("ui-id-2"))).build();
    mouseOverMenu.perform(); //accessing Enabled menu option

    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-4")));
    wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-4")));

    mouseOverMenu = builder.moveToElement(driver.findElement(By.id("ui-id-4"))).build();
    mouseOverMenu.perform(); //accessing Downloads submenu option

    WebElement webElement2= driver.findElement(By.cssSelector("a#ui-id-6.ui-corner-all")); // #ui-id-6 is for pdf, #ui-id-7 csv so on
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", webElement2);