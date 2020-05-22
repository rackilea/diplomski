@RunWith(Cucumber.class)
@CucumberOptions(
    format = "pretty",
    tags = {"~@Ignore"},
    features = "src/test/resources/com/me/pos/service/it/"  //refer to Feature file
)
public class CucumberIT {  }