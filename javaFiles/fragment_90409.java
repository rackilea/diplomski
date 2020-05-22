if(isElementPresent(By.xpath(XPATH1))){
        homeTable = a_chromeWebdriver.findElement(By.xpath(XPATH1));
    }
    else{
        homeTable = a_chromeWebdriver.findElement(By.xpath(XPATH2));
    }