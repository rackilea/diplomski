driver.findElements(By.cssSelector("div[ng-model='sCur'] ul")).click();

List<WebElement> currencies = driver.findElements(By.cssSelector("div[ng-model='sCur'] ul li a"));

for (WebElement option : currencies) {
    System.out.println("Text :" + option.getText());
}