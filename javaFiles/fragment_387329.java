@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.abc.ghi", "com.abc.common"},
        features = {"classpath:com/abc/ghi/",
                "classpath:com/abc/common.feature"},
        format = {"json:target/cucumber/cucumber-report-2.json"},
        tags = {"~@ignore"},
        monochrome = true)
public class CucumberRunner2 {
}