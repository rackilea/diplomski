String searchText = "AppraisersGroupTest";
WebElement dropdown = driver.findElement(By.id("grdAvailableGroups"));
dropdown.click(); // assuming you have to click the "dropdown" to open it
List<WebElement> options = dropdown.findElements(By.tagName("li"));
for (WebElement option : options)
{
    if (option.getText().equals(searchText))
    {
        option.click(); // click the desired option
        break;
    }
}