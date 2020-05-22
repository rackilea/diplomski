driver.get("http://babynames.merschat.com/index.cgi?function=Search&origin=Sanskrit&gender=f");
List<WebElement> pageOptions = new Select(driver.findElement(By.xpath("//select[@name='page']"))).getOptions();//Get all options in dropdown
ArrayList<String> pageDd = new ArrayList<String>();
for(WebElement eachPage:pageOptions){
    pageDd.add(eachPage.getText());//Save text of each option
}
int i=1;
for(String eachVal:pageDd){
    new Select(driver.findElement(By.xpath("//select[@name='page']"))).selectByVisibleText(eachVal);//Select page
    driver.findElement(By.xpath("//input[@value='Go']")).click();//Click on go
    List<WebElement> names = driver.findElements(By.xpath("//a[contains(@title,' meanings and popularity')]"));//Get all names on page
    for(WebElement eachName:names){
        String name = eachName.getText(); //Get each name's text
        WebElement mean = eachName.findElement(By.xpath("./../../..//a[contains(@title,'Names for baby with meanings like ')]"));//Get meaning for that name
        String meaning = mean.getText();//Get text of meaning
        System.out.println(i+") Name: " +name+ " Meaning:  " + meaning);//Print the data
        i++;
    }
}