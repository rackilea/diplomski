public void selectFilter(String filter) {
    Iterator iter = elements.iterator();
    if (iter.hasNext()) {
        WebElement element = (WebElement)iter.next();
        if (element.getText().equals(filter))
        {
            new Actions(webDriver).moveToElement(element).perform();
        }
    }

}