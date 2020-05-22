/**
 * Executes a script on an element
 * @note Really should only be used when the web driver is sucking at exposing
 * functionality natively
 * @param script The script to execute
 * @param element The target of the script, referenced as arguments[0]
 */
public void trigger(String script, WebElement element) {
    ((JavascriptExecutor)driver).executeScript(script, element);
}

/** Executes a script
 * @note Really should only be used when the web driver is sucking at exposing
 * functionality natively
 * @param script The script to execute
 */
public Object trigger(String script) {
    return ((JavascriptExecutor)driver).executeScript(script);
}

/**
 * Opens a new tab for the given URL
 * @param url The URL to 
 * @throws JavaScriptException If unable to open tab
 */
public void openTab(String url) {
    String script = "var d=document,a=d.createElement('a');a.target='_blank';a.href='%s';a.innerHTML='.';d.body.appendChild(a);return a";
    Object element = trigger(String.format(script, url));
    if (element instanceof WebElement) {
        WebElement anchor = (WebElement) element; anchor.click();
        trigger("var a=arguments[0];a.parentNode.removeChild(a);", anchor);
    } else {
        throw new JavaScriptException(element, "Unable to open tab", 1);
    }       
}