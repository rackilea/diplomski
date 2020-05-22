public class lambdaTestDefinitions implements En {
    public lambdaTestDefinitions(BaseDefinitions baseDefinitions) {

        Given("I try to navigate to www.google.co.uk", () -> {
            baseDefinitions.getDriver().get("http://www.google.co.uk");
        });

        Then("I should be on the Google home page", () -> {
            // Write code here that turns the phrase above into concrete actions
            assertEquals(baseDefinitions.getDriver().getCurrentUrl(), "http://www.google.co.uk");
        });
    }
}