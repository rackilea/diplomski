referenceIn3DPage=Driver.driver.findElements(By.xpath("//div[3][@class='some-class']/div"));

for(WebElement e : referenceIn3DPage.sublist(0,9)) { 
    String idVal = e.findElement(By.ByTagName("label").getAttribute("id"));
    System.out.println(idVal);
}