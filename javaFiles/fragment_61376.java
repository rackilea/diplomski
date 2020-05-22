public class tableTestStepDefs {

@FindBy(how = How.XPATH, using = "//*[@id=\"contenido-table\"]/tbody/tr[1]/td[3]")
public WebElement cell1;
@FindBy(how = How.ID, using = "\"DTE_Field_sufijo\"")
public WebElement editableCell1;

public tableTestStepDefs() { //this!
    PageFactory.initElements(driver, this);
}

@When("^i click on cell1 to make it editable$")
public void hagoClickEnUnaCeldaDeLaColumnaSufijo(){
driver.get("http://192.168.242.104:7777/some/context");
cell1.click();
}