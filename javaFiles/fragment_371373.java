Got the solution.Thanks:)

public static void tempdrop() {
    Select oSelect = new Select(driver.findElement(By.tagName("select")));
    List <WebElement> elementCount = oSelect.getOptions();
    System.out.println(elementCount.size());
    for(int i =0; i<elementCount.size() ; i++){
        String sValue = elementCount.get(i).getText();
        System.out.println(sValue);
        }
    oSelect.selectByVisibleText("Shamshabad-21:15");
    }