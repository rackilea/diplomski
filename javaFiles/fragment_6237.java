//maximizing the window for better view
driver.manage().window().maximize();

//a selector to find all the links on the page
By selector = By.xpath("//p[@class='title']/a[1]");

//finding the list of all elements
List<WebElement> list = driver.findElements(selector);

/*Iterating over the collection may throw StaleElementReference exception due to DOM refresh
according to my knowledge for loop is best in such case
*/
for (int i = 0; i<list.size(); i++){

    new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(selector));

    //Click on the title
    driver.findElements(selector).get(i).click();

    //Navigating back to the main page. This is not feasible but no other option present due to page structure
    driver.navigate().back();
}