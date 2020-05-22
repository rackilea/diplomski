@Given("^User is on Homepage$")
public void user_is_on_Homepage() throws Throwable {

    ConfigFileReader cnffilered= new ConfigFileReader();
    cnffilered.getBrowserType();
    cnffilered.getUrl();
    cnffilered.Implicitwait();
    cnffilered.MaxmimizeWindow();
    **this.driver = cnffilered.getDriver();**
}