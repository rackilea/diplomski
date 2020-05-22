WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement label = wait.until(new ExpectedCondition<Boolean>() {
    public Boolean apply(WebDriver driver) {
        return driver.findElement(By.id("current_heat_setpoint")).getText().length() > 0;
    }
});
System.out.println(label.getText());