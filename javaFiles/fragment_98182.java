Actions actions = new Actions(driver);
WebElement menuHoverLink = driver.findElement(By.linkText("Menu heading"));
actions.moveToElement(menuHoverLink);

WebElement subLink = driver.findElement(By.cssSelector("#headerMenu .subLink"));
actions.moveToElement(subLink);
actions.click();
actions.perform();