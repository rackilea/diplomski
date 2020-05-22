//first create a web element list which contains all elements inside a list:

List<WebElement> elems = driver.findElements(By.cssSelector("ul.NoIndent>li.NoBullet.jms-bullet> h3>a"));

//Now you can select individual elements from a list using:

 elems.get(0).click();//for the 1st element
 elems.get(1).click();//for the 2nd element
 elems.get(2).click();//for the 3rd element