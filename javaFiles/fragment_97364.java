if (driver.getPageSource().contains("Team"))
    {
         WebElement elem = driver.findElement(By.partialLinkText("Team"));      
         //get the href attr
         String url = elem.getAttribute("href");         
         //add code to go to the url above
    }