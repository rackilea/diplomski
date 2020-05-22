import cucumber.api.java.en.When;

@ScenarioScoped
public class TestStepToBeRemoved {
    String x;

    @When("^user sets value of varibale x$")
    public void setValueOfx() {
        x = "Random Text";
    }

    @When("^user retrives value of x$")
    public void retriveValueOfX() {
        System.out.println("Value of X is : " + x);
    }
}