Wait<WebDriver> wait = new FluentWait<>(driver)
    .withTimeout(60, TimeUnit.SECONDS)
    .pollingEvery(5, TimeUnit.SECONDS)
    .ignoring(NoSuchElementException.class);

wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='bla bla']"));