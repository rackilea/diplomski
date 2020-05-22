driverChrome.manage().window().maximize();
driverChrome.get("chrome://settings");
WebElement w = driverChrome.findElement(By.xpath("//iframe[@name='settings']"));
driverChrome = driverChrome.switchTo().frame(w);

WebDriverWait wait = new WebDriverWait(driverChrome, 10);
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Show advanced settings...']"))).click();

// alternative example... store returned element and then click on a separate line... or use the variable elsewhere, etc.
// WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Show advanced settings...']")));
// link.click();