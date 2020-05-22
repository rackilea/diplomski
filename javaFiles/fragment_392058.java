package tests.report.runners;
  import org.testng.annotations.Test;
  import cucumber.api.testng.AbstractTestNGCucumberTests;
  import cucumber.api.CucumberOptions;
  @Test
  @CucumberOptions(features = "src/test/resources/features",glue= {"tests"},tags= 
  {"@Report"})
  public class ReportRunner extends AbstractTestNGCucumberTests {
  }