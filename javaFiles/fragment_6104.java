List<WebElement> links = driver.findElements(By.className("search-results"));
for( int i = 0; i < links.size(); i++)
{
    //The stop below is necessary to store all links in a list to access later.  
    links = driver.findElements(By.className("search-results")); 
    links.get(i).click();
    // Your code here
    driver.navigate().back();
}