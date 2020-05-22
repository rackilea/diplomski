@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.abc.def", "com.abc.common"},
        features = {"classpath:com/abc/def/",
                "classpath:com/abc/common.feature"},
        format = {"json:target/cucumber/cucumber-report-1.json"},
        tags = {"~@ignore"},
        monochrome = true)
public class CucumberRunner1 {
}