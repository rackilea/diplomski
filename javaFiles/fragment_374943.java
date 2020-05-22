By buttonLocator = By.id(""); // the button that when clicked exposes the dropdown
By optionsLocator = By.id(""); // the options in the dropdown
driver.findElement(buttonLocator).click();
List<WebElement> options = driver.findElements(optionsLocator);
for (int i = 0; i < options.size(); i++)
{
    driver.findElements(By.id("")).get(i).click(); // click the option
    // code that detects success or error
    driver.navigate().refresh();
}