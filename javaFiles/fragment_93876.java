int index=1;
List <WebElement> allElement = driver.findElements(By.xpath("(//div[@class='table_class'])"));
for(WebElement element: allElement)
{
    String className = element.getText();
    Reporter.log("=====Class Identified as "+className+""+index+""+"=====", true);
    index++
}