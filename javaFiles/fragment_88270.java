@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", monochrome = true, glue = { "com.scripts" }, plugin = { "pretty","html:target/cucumber" },
         tags = {"@sa,@sanity" },
        // dryRun = false)
public class RunnerClass {

}