((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 
elem1);
    Thread.sleep(500); 

    Actions newwin = new Actions(driver);
    newwin.keyDown(Keys.SHIFT).click(elem1).keyUp(Keys.SHIFT).build().perform();