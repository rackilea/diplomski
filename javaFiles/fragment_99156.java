List<WebElement> lista1 = null;
int size = 1;

for (int i = 0 ; i < size ; ++i) {
    lista1 = driver.findElements(By.cssSelector(".tl.nobr > a")); //locate all the links
    size = lista1.size(); //change the loop itreations number to the right one
    lista1.get(i).click(); //click on the link
    System.out.println(Sdriver.findElement(By.id("nm-date")).getText()); //print the data
    driver.navigate().back(); //go to previous page
}