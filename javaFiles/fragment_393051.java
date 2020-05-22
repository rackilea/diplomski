WebElement drop = driver.findElement(By.cssSelector("#ctl00_mainPanel_MainPanel1_SearchStop1_DropDownRoute"));

Select sel_drop = new Select(drop);
List<WebElement> drop_count = sel_drop.getOptions();
int drop_size = drop_count.size();
System.out.println("size of drop down" + drop_size);
sel_drop.selectByIndex(1);

//below lines are crucial
drop = driver.findElement(By.cssSelector("#ctl00_mainPanel_MainPanel1_SearchStop1_DropDownRoute"));
sel_drop = new Select(drop);

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(250,0)", "");

sel_drop.selectByIndex(10);//this line is causing error-- when I am trying to select element from dropbox for second time.