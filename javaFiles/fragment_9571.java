FirefoxDriver driver = new FirefoxDriver();
driver.get("https://www.youtube.com/watch?v=JcbBNpYkuW4");

WebElement element = driver.findElementByCssSelector("#watch-discussion");
System.out.println(element.getText()); // this prints: loading..

// scrolll down so that comments start to load
driver.executeScript("window.scrollBy(0,500)", "");

Thread.sleep(20000);

List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));

for(WebElement e : iframes) {       
    if(e.getAttribute("id") != null && e.getAttribute("id").startsWith("I0_")) {
    // switch to iframe which contains comments
    driver.switchTo().frame(e);
    break;
    }
}

// fetch all comments
List<WebElement> comments = driver.findElements(By.xpath("//div[@class='Ct']"));
for(WebElement e : comments) {      
    System.out.println(e.getText());
}