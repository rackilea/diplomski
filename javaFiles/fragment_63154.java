int counter = 0;
for (WebElement e : testItems) {
    if (e.isDisplayed()) {
        counter++;
    }
}