public static boolean isElementClickable(WebElement element) { 
    return element.isDisplayed() && element.isEnabled() && 
    element.equals(getJSExecutor(getDriverFromContext(element)) .executeScript(
        "return document.elementFromPoint" + "(" + 
        Integer.toString(((Locatable)element).getLocationOnScreenOnceScrolledIntoView().getX() + 
        (element.getSize().getWidth() / 2)) + ", " + 
        Integer.toString(((Locatable)element).getLocationOnScreenOnceScrolledIntoView().getY() + 
        (element.getSize().getHeight() / 2)) + ")")); 
}