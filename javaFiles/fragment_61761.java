Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
           .withTimeout(30, SECONDS)
           .pollingEvery(5, SECONDS)
           .ignoring(NoSuchElementException.class, ElementNotFoundException.class);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Liferay")));
driver.get(baseUrl + "/user/tm2/so/dashboard");
driver.findElement(By.xpath("//h3[contains(., 'Not Found')]"));