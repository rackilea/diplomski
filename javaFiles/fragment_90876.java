public WebElement locateElement(WebDriver driver, String Locater,
            String LocateBy) {
        try {
        switch (LocateBy.toLowerCase()) {
        case "xpath":
        return driver.findElement(By.xpath(Locater));
        case "id":
        return driver.findElement(By.id(Locater));
        ....
        //So on
        default:
        return null;
        }
        } 
        catch (Exception e) 
        {
            //Write to log or custom error message
        }
        return null;
        }