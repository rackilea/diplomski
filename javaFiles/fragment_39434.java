public class StepDefinition {

    private GoogleHomePO gmPO;

    public StepDefinition(SharedDriver driver, GoogleHomePO gmPO) {
        this.gmPO = gmPO;
    }

    @Given("Go to google page")
    public void given() {
        gmPO.get();
    }

    @When("Enter search {string}")
    public void when(String search) {
        gmPO.enterSearch(search);
    }    
}