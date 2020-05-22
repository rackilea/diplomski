int size = 1;
for (int i = 0 ; i < size ; ++i) {
    List<WebElement> elementList = driver.findElements(By.className("classname"));
    elementList.get(i).click(); // click the element by index
    size = elementList.size();  // change "size" to the list size

    //fetching some values
    String str = driver.findElement(By.className("classname")).getText();

    System.out.println("Value : "+str);

    //returning back to the first page
    driver.findElement(By.xpath(".//[@id='pane']/div/div[1]/div/button")).click();
}