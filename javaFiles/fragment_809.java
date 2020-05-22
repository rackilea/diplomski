driver.get("www.xyz.com");  
WebElement element = driver.findElement(By.id(Value));
List<WebElement> elements = element.findElements(By.tagName("a"));
int sizeOfAllLinks = elements.size();
System.out.println(sizeOfAllLinks);

for(int i=0; i<sizeOfAllLinks ;i++)
{
     System.out.println(elements.get(i).getAttribute("href"));
}

for (int index=0; index<sizeOfAllLinks; index++ )
{
     getElementWithIndex(By.tagName("a"), index).click();
     driver.navigate().back();
}

public WebElement getElementWithIndex(By by, int index)
{
     WebElement element = driver.findElement(By.id(Value));
     List<WebElement> elements = element.findElements(By.tagName("a")); 
     return elements.get(index);
}