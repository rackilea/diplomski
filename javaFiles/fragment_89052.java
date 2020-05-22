WebElement ulList = driver.findElement(By.className("list"));

List<WebElement> values = ulList.findElements(By.tagName("li"));

int i = values.size();
System.out.print("Options = " + i);