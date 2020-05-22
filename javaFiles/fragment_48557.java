public ObjectPage filter(int lowerThreshold, int highThreshold) {
    Actions action = new Actions(getWebDriver());
    action.dragAndDropBy(findElement(".className .thumbMin"), lowerThreshold, 0).perform();
    waitFor(elementIsNotDisplayed("#waiting_dialog"));

    action.dragAndDropBy(findElement(".className .thumbMax"), highThreshold, 0).perform();
    waitFor(elementIsNotDisplayed("#waiting_dialog"));
    return this;
}