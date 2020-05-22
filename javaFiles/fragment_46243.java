By AutomaticDataLockTimed = By.xpath("//span[@class='ant-radio']//input[@name='automaticDataLock']");

// locate the element using AutomaticDataLockTimed locator
WebElement element = webdriver.findElement(AutomaticDataLockTimed);

if (!element.getAttribute("value").equals("true"))
{
    JSUtil.clickElementUsingBySelector(AutomaticDataLockTimed, driver);
}