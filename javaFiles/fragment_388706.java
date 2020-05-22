public class Registration_Page_POF {

public WebDriver driver;

//Personal details WebElements
@FindBy(css = "form#personalDetailsForm div.profile.pe div.profile-block.simple.first fieldset#pefield-title select#pesalutation")
public WebElement titleDropdown;
public Select titleSelect; //Dont initialize here

public Registration_Page_POF(WebDriver driver) {
this.driver = driver;

PageFactory.initElements(driver, this);
titleSelect = new Select(titleDropdown);//initialize here
}

}