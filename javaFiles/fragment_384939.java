public static WebElement findElementByRegexId(FindsByTagName ctx, String tagName, String regex) {
    List<WebElement> l = ctx.findElementsByTagName(tagName);
    for (WebElement e : l) {
        if (e.getAttribute("id").matches(regex)) {
            return e;
        }
    }
    return null;
}