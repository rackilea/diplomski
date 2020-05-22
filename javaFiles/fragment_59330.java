// Click select first:
// (See http://code.google.com/p/selenium/issues/detail?id=2112)
findElement(By.xpath(DropDown_Article_Size_XPATH_ID)).click();

// Then click option:
String xpathOption = String.format("%s/option[text()='%d']",
    DropDown_Article_Size_ID, size);
log.debug("Selecting option by text '{}' using xpath '{}'", size, xpathOption);
findElement(By.xpath(xpathOption)).click();