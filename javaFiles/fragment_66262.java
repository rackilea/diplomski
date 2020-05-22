public String varLocator(String locator, String holder1, String param1, String holder2, String param2) {

return locator.replace(holder1, param1).replace(holder2, param2);

}

public void sample() {

String eleLocator = "//div[@id='%s1']//div[@class='%s2']";

WebElement foo = driver.findElement(By.xpath(varLocator(eleLocator, "%s1", "foo", "%s2", "bar")));

}