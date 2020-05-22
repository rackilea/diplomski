/** Maps IDs of all textboxes to their value attribute. */
public Map<String,String> getTextBoxIds() {
    Map<String,String> textboxIds = new HashMap<>();

    // find all textboxes
    List<WebElement> textboxes = driver.findElements(By.cssSelector("input[type='text']"));
    // map id of each textbox to its value
    for (WebElement textbox : textboxes) {
        textboxIds.put(textbox.getAttribute("id"), textbox.getAttribute("value"));
    }

    return textboxIds;
}