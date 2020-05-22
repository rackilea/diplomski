@RunWith(Courgette.class)
@CourgetteOptions(
    threads = 10,
    runLevel = CourgetteRunLevel.SCENARIO,
    rerunFailedScenarios = true,
    showTestOutput = true,
    cucumberOptions = @CucumberOptions(
            features = "src/test/resources/features",
            glue = "steps",
            tags = {"@regression"},
            plugin = {
                    "pretty",
                    "json:target/courgette-report/courgette.json",
                    "html:target/courgette-report/courgette.html"}
    ))
    public class RegressionTestSuite {
    }