new WebDriverWait(driver, 5).until(drv -> {
    List<WebElement> elements = drv.findElements(By.xpath("//[@name='title']"));
    return elements.stream()
        .filter(WebElement::isDisplayed)
        .findFirst()
        .orElse(null);
});