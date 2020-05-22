@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/test/features/"},            
        glue = {"test.steps"},        
        tags = {""},        
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" +
                "path"}
)
public class RunCucumberTest {
}