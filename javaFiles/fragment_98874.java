public class StepDefinition{
  private final Map<String, YourPageObject> pageObjectsIndex;

  @Autowired
  public StepDefinition(List<YourPageObject> yourPageObjects){
    pageObjectsIndex = yourPageObjects.stream().collect(Collectors.toMap(page -> page.getPageHeading().getText().toUpper(), Function.identity());
  }

  @Then("^user is navigated to \"([^\"]*)\"$")
   public void userIsNavigatedTo(final String pageHeading) throws IOException {
     Assert.assertTrue(pageObjectsIndex.get(pageHeading.toUpper()).isLoaded());
   }
}