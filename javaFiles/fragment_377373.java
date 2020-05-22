public static void selectByValue(WebElement element, String value) {
    Select selectElement = new Select(element);
    selectElement.selectByValue(value);
}
public static void selectByText(WebElement element, String text) {
    Select selectElement = new Select(element);
    selectElement.selectByVisibleText(text);
}