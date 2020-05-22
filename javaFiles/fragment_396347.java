List <WebElement> listofItems = wd.findElements(By.xpath("//*[starts-with(@id,'result_')]//div//div[1]//div//a//img"));
WebDriverWait wait = new WebDriverWait(wd, 20); //Wait time of 20 seconds

for (int i=1; i<=listofItems.size(); i++)
{ 
    /*Getting the list of items again so that when the page is
     navigated back to, then the list of items will be refreshed
     again */ 
    listofItems = wd.findElements(By.xpath("//*[starts-with(@id,'result_')]//div//div[1]//div//a//img"));

    //Waiting for the element to be visible
    //Used (i-1) because the list's item start with 0th index, like in an array
    wait.until(ExpectedConditions.visibilityOf(listofItems.get(i-1)));

    //Clicking on the first element 
    listofItems.get(i-1).click();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    System.out.print(i + " element clicked\t--");
    System.out.println("pass");
    wd.navigate().back(); 
}