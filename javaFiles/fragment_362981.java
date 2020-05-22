public class MyRadio {
    // map to store radios
    Map<String, WebElement> elementMap = new HashMap<String, WebElement>(); 

    MyRadio(By by) {
        // find all radios
        List<WebElement> elements = driver.findElements(by);
        // iterate through radios and add to a map
        for (WebElement element: elements) {
            elementMap.put("radio"+element.getAttribute("value"), element);
        }     
    }

    public WebElement getRadio(String radioName) {
        if (elementMap.contains(radioName)) {
            return elementMap.get(radioName);
        }
        // might want to throw a custom exception here like noRadioFoundException
        return null;
    }
}


MyRadio myRadioInstance = new (By.ByName("test"));
myRadioInstance.getRadio("radio1");
myRadioInstance.getRadio("radio2");