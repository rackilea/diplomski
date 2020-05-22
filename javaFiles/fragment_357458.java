public class LogonPage {
@FindBy(id="UserName")
public WebElement userNameField;
@FindBy(id = "Password")
public WebElement passwordField;
@FindBy(css = "input.submitBtn")
public WebElement submitButton;

public LogonPage(WebDriver driver){
    PageFactory.initElements(driver, this);
}
public void portalLogin(String username, String password){ //Only call this when you are already on the logon page
        userNameField.clear();
        userNameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        submitButton.click();
        //Waiting should also be done after the function
}