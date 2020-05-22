WebElement element = null;
long targetTime = System.currentTimeMillis() + TIMEOUT_TIME;
try
{
    while ((element == null) && (System.currentTimeMillis() < targetTime))
    {
        try
        {
            element = driver.findElement(By.xpath(xpath));
        }
        catch (NoSuchElementException e) { /* do nothing */ }
    }
}