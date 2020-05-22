public WebElement findElement(By locator) {
    driver.switchTo().defaultContent();
    //list all iframes
    List<WebElement> iframeList = driver.findElements(By.tagName(("iframe")));
    final List<WebElement> foundElements = new ArrayList<>();
    iframeList.forEach(iframe -> {

        driver.switchTo().frame(iframe);
        List<WebElement> foundElementList = driver.findElements(locator);
        if (foundElementList.size() > 0) {
            foundElements.addAll(foundElementList);
        } else driver.switchTo().defaultContent();
    });
    return foundElements.get(0);
}