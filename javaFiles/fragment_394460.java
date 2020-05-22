@FindBy(xpath="...")
private List<WebElement> allListEntries;

...

private WebElement getTargetListEntry(int index) {
    return allListEntries.get(index);
}