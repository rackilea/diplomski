List<WebElement> allLinks = driver.findElements(By.tagName("a"));
String ofLinks[] = new String[allLinks.size()];
for (int i = 0; i < allLinks.size(); i++){
    if(!allLinks.get(i).getText().equals("SUPPORT")){
       ofLinks[i] = allLinks.get(i).getText();
    }
}

for (int i = 0; i < allLinks.size(); i++){
    if (ofLinks[i] != null){
        driver.findElement(By.LinkText(ofLinks[i])).click();
    }
    driver.findElement(By.linkText("Home")).click();
}