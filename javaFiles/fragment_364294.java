driver.get("https://www.makemytrip.com/flights");

     driver.findElement(By.id("hp-widget__sfrom")).click();
     driver.findElement(By.id("hp-widget__sfrom")).clear();
     try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     driver.findElement(By.id("hp-widget__sfrom")).sendKeys("LON");


     List<WebElement> Cities = driver.findElements(By.xpath("//div[@class='autoCompleteItem']//span[contains(.,'London, UK - All Airports')]"));
   for (WebElement size1 : Cities )
   {
           String str = size1.getText(); 

         if(size1.getText().equalsIgnoreCase("London, UK - All Airports"))
         {
              System.out.println(size1.getText());
             size1.click();
             break;
         }
         else
         {
             System.out.println("match not found"); 
         }   
     }
   }
}