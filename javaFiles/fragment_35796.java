try{
if(driver.findElement(By.xpath(".//*[@id='d9c1cb30-3459-4246-919d-41c5fe23de2f']/div/div/article/div/ul[1]/li[3]/a")).isDisplayed())
        {
            driver.findElement(By.xpath(".//*[@id='d9c1cb30-3459-4246-919d-41c5fe23de2f']/div/div/article/div/ul[1]/li[3]/a")).click();     
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            Thread.sleep(4000);  

            System.out.println(driver.findElement(By.xpath(".//*[@id='d9c1cb30-3459-4246-919d-41c5fe23de2f']/div/div/article/dl/dd[3]/a")).getText());
            System.out.println(driver.getCurrentUrl());
            driver.navigate().back();
            driver.navigate().back();
        }
        else
        {
            System.out.println("No Teaching Notes Present");
            driver.navigate().back();

        }
}catch(Exception e){
  System.out.println("No Teaching Notes Present");
            driver.navigate().back();
 }