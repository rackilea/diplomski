public class LoginPage extends TestBase {

public LoginPage() {
    PageFactory.initElements(driver, this);//Here driver is initialised in TestBase class and inherited in LoginPage class
}
//your code

@FindBy(id="listAccounts")
WebElement accountDropdown;

public void selectAccount(){
logger.info("Selecting Account");
implicitwait(10);
Select dropdown = new Select(accountDropdown);
logger.info("Drop down is multiple::"+ dropdown.isMultiple());
}
}