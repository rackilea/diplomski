String tt = "No more candidates awaiting Authorization";
String nomore = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-scope' and contains(@data-ng-if,'newRequestReceived')]//p[@class='ng-scope' and contains(@data-ng-if,'authRequestCount')]"))).getAttribute("innerHTML");


boolean run = true;

while(run)
{
    if (nomore.contentEquals(tt))
        {
        driver.navigate().to("https://mettl.com/corporate/live-feed#/proctoringDashboard");
        driver.findElement(By.xpath("//label[@class='checkbox ng-binding']//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Authorize')]")).click();
        Thread.sleep(750);
        System.out.println("Not Available");

        }
    else
        {
        System.out.println("Available");
        //Thread.sleep(10000);
        //break;
        run = false; /*Stopps the loop*/                           
        } 

}