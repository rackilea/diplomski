/**
 * Switches to the non-current window
 */
public void switchWindow() throws NoSuchWindowException, NoSuchWindowException {
    Set<String> handles = driver.getWindowHandles();
    String current = driver.getWindowHandle();
    handles.remove(current);
    String newTab = handles.iterator().next();
    locator.window(newTab);
}