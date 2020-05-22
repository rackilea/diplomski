//clicks on ShowAll button
    driver.findElement(By.xpath("//*[@id='secondary']/div[1]/div[2]/div/div[1]/a")).click();
    Thread.sleep(5000);

     //gets parent for Categories
     WebElement parentElement = driver.findElement(By.xpath("//*[@id='secondary']/div[1]/div[2]/div/ul"));

    //gets parent for Categories shown after clicking ShowAll
    WebElement secondParentElement = driver.findElement(By.xpath(".//*[@id='secondary']/div[1]/div[2]/div/div[2]/ul"));


    List<WebElement> allBrands = parentElement.findElements(By.cssSelector("li >a"));
    List<WebElement> allBrandsInShowAll =secondParentElement.findElements(By.cssSelector("li >a"));

    System.out.println("Total No of Brands "+(allBrands.size() + allBrandsInShowAll.size()));

    for(WebElement ele :allBrands) {
     System.out.println("Name=>"+ele.getText()); 
    }

    for(WebElement ele :allBrandsInShowAll) {
         System.out.println("Name=>"+ele.getText()); 
        }

    driver.quit();

   }

    }