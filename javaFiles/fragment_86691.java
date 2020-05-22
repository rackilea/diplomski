//Fetch the elements before doing the operation
    List<WebElement> elements = driver.findElements(By.xpath("//g[contains(@id,'j_')]"));
    // You would be getting the last value present by using getAttribute
    String lastElement = elements.get(elements.size()-1).getAttribute("id");

    //Perform the drag and drop operation now

    //Fetch the elements again
    List<WebElement> newElements = driver.findElements(By.xpath("//g[contains(@id,'j_')]"));
    // Fetch the id attribute again and verify that the j count has incremented and then you can fetch the last element, which is your new element now 
    String newLastElement = newElements.get(elements.size()-1).getAttribute("id");
    // Your new element can be found using
    WebElement requiredElement = newElements.get(elements.size()-1);
    String modelId = requiredElement.getAttribute("model-id");