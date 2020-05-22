public class CustomExpectedCondition {

public static ExpectedCondition<List<WebElement>> moreThanOne(
        final By locator) {
    return driver -> {
        List<WebElement> elements = getDriver().findElements(locator);
        return elements.size() > 1 ? elements : null;
    };

}
}