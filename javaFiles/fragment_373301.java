public static void main(String[] args) {
    WebDriver HP=new ChromeDriver();
    HP.get("https://**********************/");
    HP.manage().window().maximize();
    clickLinkAndGoBack(HP, "Northland");
    clickLinkAndGoBack(HP, "Auckland");
    clickLinkAndGoBack(HP, "Waikato");
    clickLinkAndGoBack(HP, "Bay of Plenty");
    clickLinkAndGoBack(HP, "Gisborne");
    clickLinkAndGoBack(HP, "Hawkes Bay");
}

private void clickLinkAndGoBack(WebDriver driver, String linkText) {
    ExpectedCondition<WebElement> condition;
    condition = ExpectedConditions.elementToBeClickable(By.linkText(linkText));
    WebElement link = new WebDriverWait(driver, 20, 1).until(condition);
    link.click();
    // actually do something after clicking (check displayed ...?)
    driver.navigate().back();
}