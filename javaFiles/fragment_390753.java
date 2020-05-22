WebElement selectorElement = driver.find(By.xpath('//*[@id="countSelect"]')));

WebElement elementOfInterest;
try {
    //trying to get the "select option"
    elementOfInterest = selectorElement.findElement(By.xpath('//*[contains(@class,"selec_option")]/td[@text()="50"]'))

} catch (NoSuchElementException e) { 
    //so options are not visible, meaning we need to click first
    selectorElement.click()
    //good idea would be to put "wait for element" here
    elementOfInterest = selectorElement.findElement(By.xpath('//*[contains(@class,"selec_option")]/td[@text()="50"]'))
}
//this would select the option
elementOfInterest.click()