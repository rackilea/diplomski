// To Select the Item from List Box
WebElement xps = driver.findElement(By.xpath(xpath));
List<WebElement> sli = xps.findElements(By.tagName("li"));  
for (int i = 0; i < sli.size(); i++) 
{
    if (sli.get(i).getText().equalsIgnoreCase(Itemtext)) 
    {
        sli.get(i).click();
        break;
    }
    else{System.out.println("Item not fount in the list");}
}
//Click on Arrow Icon outside the List box to move the Item
driver.findElement(By.cssSelector("i.icn.cir-fwd")).click();