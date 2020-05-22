@FindBy(xpath = "//select")
private WebElement lstDevice;

public WebElement lstSelectDevice() {

    new Select(lstDevice).selectByVisibleText("Mouse");
    return lstDevice; //Not sure why u need this...
}