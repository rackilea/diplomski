driver.get("https://www.makemytrip.com/")
new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='input_fromto checkSpecialCharacters ui-autocomplete-input' and @id='hp-widget__sfrom']"))).click();
List<WebElement> myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item'][starts-with(@id,'ui-id-')]//span[@class='autoCompleteItem__label']")));
for (WebElement element:myList)
    if(element.getText().contains("Mumbai"));
        element.click();