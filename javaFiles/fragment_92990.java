public void click(WebElement element)
    {
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
Thread.sleep(500);
        if(element.isDisplayed())
    element.click();
    }