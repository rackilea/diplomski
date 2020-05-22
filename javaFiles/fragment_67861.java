new WebDriverWait(driver, 5).until(drv -> {
    List<WebElement> elements = drv.findElements(By.xpath("//[@name='title']"));
    for (WebElement element : elements) {
        if (element.isDisplayed()) {
            return element;
        }
    }
    return null;
});