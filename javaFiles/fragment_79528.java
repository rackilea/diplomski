@FindBy(xpath = "//label[contains(@class, 'CheckboxTextAligned')]/following::input")
private List<WebElement> airportListCheckbox;

public void getEnabledValues() {
for (WebElement elements : airportListCheckbox) {
    if(elements.isEnabled()) {
        for (WebElement airportText : airportListTextName) {
        airportText.getText();
        LOG.info(airportText.getText());                
        }
    }       
}