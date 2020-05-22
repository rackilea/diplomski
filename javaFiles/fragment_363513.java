WebElement button = driver.findElement(By.id("..."));

// clicks on the button every 100ms until the alert is present
Alert alert = new WebDriverWait(driver, 20, 100).until((WebDriver drv)->{
    try{
        button.click();
        return drv.switchTo().alert();
    }catch(NoAlertPresentException ex){
        return null;
    }
});

// accept the alert
alert.accept();