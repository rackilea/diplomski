// Locate shadowHost on the current dom
WebElement shadowHostL1 = driver.findElement(By.cssSelector("settings-ui"));

// now locate the shadowElement by traversing all shadow levels
WebElement shadowElementL1 = getShadowElement(driver, shadowHostL1, "settings-main");
WebElement shadowElementL2 = getShadowElement(driver, shadowElementL1,"settings-basic-page");
WebElement shadowElementL3 = getShadowElement(driver, shadowElementL2,"settings-section > settings-privacy-page");
WebElement shadowElementL4 = getShadowElement(driver, shadowElementL3,"settings-clear-browsing-data-dialog");
WebElement shadowElementL5 = getShadowElement(driver, shadowElementL4,"#clearBrowsingDataDialog");
WebElement clearData = shadowElementL5.findElement(By.cssSelector("#clearBrowsingDataConfirm"));
System.out.println(clearData.getText());
clearData.click();