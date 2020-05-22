String url = "https://amzscout.net/sales-estimator";                        

// true enables javascript support                                          
WebDriver driver = new HtmlUnitDriver(true);                                
try {                                                                       
    driver.get(url);                                                        

    // wait until the elements are created                                  
    List<WebElement> elements =
            new WebDriverWait(driver, 10)               
                .until(ExpectedConditions                                   
                    .numberOfElementsToBeMoreThan(                          
                            By.cssSelector("span.cat-pick_name-in"), 29));  

    System.out.println();                                                   
    for (WebElement ele : elements) {                                       
        System.out.println(ele.getAttribute("innerHTML"));
    }
} finally {                                                                 
    driver.quit();                                                          
}