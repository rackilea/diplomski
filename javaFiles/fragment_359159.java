List<WebElement> List = driver.findElements(By.xpath(".//*********"));

    // System.out.println(List.size()); // Print total count

    for (int i = 0; i<List.size(); i++) 
    {    
        System.out.println(List.get(i).getText());          
    }