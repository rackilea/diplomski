driver.get("https://ecabportal.azurewebsites.net/dashboard");
new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email"))).sendKeys("admin@malbork.in");
driver.findElement(By.name("password")).sendKeys("NsSaNj@0205");
driver.findElement(By.name("signIn")).click();
new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(., 'Dashboard')]")));
driver.get("https://ecabportal.azurewebsites.net/user");
new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='load']")));
new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.select2-selection.select2-selection--single>span.select2-selection__rendered"))).click();
new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select2-results']//li[contains(., 'User Name')]"))).click();