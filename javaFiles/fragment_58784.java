public static void addInternetQuoteByName(String Name) 
{
    WebDriver driver = new FirefoxDriver();
    int rowCount = driver.findElements(By.xpath("xpath of table")).size();

    for (int i = 1; i <= rowCount; i++) 
    {
        String sCellValue = driver.findElement(By.xpath("XPATH Of Name row")).getText();

        if (sCellValue.equalsIgnoreCase(Name)) 
        {
             driver.findElement(By.xpath("xpath of add")).click();
        }
    }

    driver.close();
}