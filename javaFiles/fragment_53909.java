package runners;

import PageObjectRep.CF;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReader;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//src//test//java//FeatureList",glue = "stepDefinations",
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:",
                "junit:target/cucumber-results.xml"},
        tags="@test",
        monochrome = true
)
public class TestRunner {
    static String ReportName= CF.ReportName(); //function which creates file name as per the execution and saved in string.
    @BeforeClass
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("target/cucumber-reports/"+ReportName+".html"); //used same string name to create the file with the same name.
        PropertyConfigurator.configure(".//src//log4j.properties");
    }