List<WebElement> links = driver.findElements(...);
if (links.isEmpty())
{
    // element doesn't exist
}
else
{
    // element exists
    links[0].click(); // or whatever
}