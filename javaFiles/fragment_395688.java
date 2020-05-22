public class Steps {
   private State state;

   public Steps(State state) {
      this.state = state;
   }

   @Given("the following happens: $string")
   public void somethingHappens(String string) {
      state.setState(string);
   }

   @When("who knows")
   public void whoKnows() {
      String stat = state.getState();
   }

   @BeforeScenario
   public void cleanup() {
      state.setState(null);
   }
}