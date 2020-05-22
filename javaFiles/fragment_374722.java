String className = "form-control btn btn-clear";
    String htmlElement = "input";
    String textToFind="\\ue01d"; // unicode value

    List<WebElement> elements = Common.findElementsUsingHtmlXpathClass(driver, htmlElement, className);

    Common.myPrint(thisClass + " elements count: " + elements.size());
    for (WebElement element : elements) {
        String text = element.getAttribute("value");
        if (text != null) {
            if (text != "") {
                text = text.trim();
                if(text.contains(textToFind)) {
                    return Common.scrollIntoView(element, driver);
                }
            }
        }
    }
    return false;