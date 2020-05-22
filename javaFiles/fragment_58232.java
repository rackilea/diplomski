boolean newPageOpened = true;
while (newPageOpened) {
    List<WebElement> findData = driver.findElements(By.xpath("//input[@ng-attr-id='{{item.attr}}']"));
    for (WebElement webElement : findData) {
        if (webElement.isDisplayed()) {
            String printGroupName = webElement.getAttribute("value").toString();
            System.out.println(printGroupName);
        }
    }

    WebElement nextButton = driver.findElement(By.xpath("//button[@ng-click='currentPage=currentPage+1']"));
    if (nextButton.isEnabled()) {
        action.moveToElement(nextButton).click().perform();
        page.pagecallingUtility();
    } else {
        newPageOpened = false;
    }
}