static void confirmDialog(WebDriver driver) {
    if (driver instanceof PhantomJSDriver) {
        PhantomJSDriver phantom = (PhantomJSDriver) driver;
        phantom.executeScript("window.alert = function(){}");
        phantom.executeScript("window.confirm = function(){return true;}");
    } else driver.switchTo().alert().accept();
}