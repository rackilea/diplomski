if (driver.findElements(By.xpath("xpath goes here").size()==0){
     int size = driver.findElements(By.tagName("iframe")).size();
     for(int iFrameCounter=0; iFrameCounter<=size; iFrameCounter++){
        driver.switchTo().frame(iFrameCounter);
        if (driver.findElements(By.xpath("xpath goes here").size()>0){
            System.out.println("found the element in iframe:" + Integer.toString(iFrameCounter));
            // perform the actions on element here
        }
        driver.switchTo().defaultContent();
    }
 }