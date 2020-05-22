// get all p tags
List<WebElement> pTags = driver.findElements(By.cssSelector("div.CLASS1 > p"));

WebElement myWebElement = null;

// iterate and find p tag that contains i.CLASS2
for (WebElement element : pTags) {
    if (element.findElements(By.cssSelector("i.CLASS2")).size() == 1) {
        myWebElement = element.findElement(By.cssSelector("strong"));
        break;
    }
}

// the data you want
System.out.println(myWebElement.getText());