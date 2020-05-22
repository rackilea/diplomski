public void checkAlert() 
{
    try 
    {
        // Wait for the alert is present
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Close the alert
        alert.accept();
    } 
    catch (Exception e) 
    {
        //exception handling
    }
}