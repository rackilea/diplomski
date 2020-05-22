WebElement parentElement = driver.findElement(By.xpath("//*[@id='secondary']/div[1]/div[2]/div/ul"));

    List<WebElement> allBrands = parentElement.findElements(By.cssSelector("li >a"));

    for(WebElement ele :allBrands) {
     System.out.println("Name=>"+ele.getText()); 
    }