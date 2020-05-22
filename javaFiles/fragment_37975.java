@CucumberOptions(features = {"src/test/resource/features"},
                 glue={"stepdefs"},
                 monochrome = true,
                 tags = {"~@Ignore"},
                 plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty",
                           "json:target/cucumber-reports/CucumberTestReport.json",
                           "rerun:target/cucumber-reports/rerun.txt",
                           "usage:target/cucumber-usage.json"}
)
public class TestRunner extends ExtendedTestNGRunner{
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}