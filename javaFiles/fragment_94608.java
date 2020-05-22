List<WebElement> elements = driver.findElements(By.locator);

if(elements.size()>0)
{
    elements.get(0).click()
}