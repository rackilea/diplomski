public void waitUntilFieldIsPopulated(WebElement element) {
    try {
        wait.until(webElemBooleanFunction(getElementValue(element).length() > 0));
    } catch (Exception e) {
        e.printStackTrace();
        logger.error(e.toString());
    }
}