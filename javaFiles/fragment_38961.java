@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"progress",
            "html:build/report/html",
            "junit:build/report/junit/cucumber-report.xml",
            "json:build/report/json/cucumber-report.json"
    },
    glue = {"com.abc.commercial.def.automation"},
    features = {"src/test/java/features"}
    )
public class QARunner {

}