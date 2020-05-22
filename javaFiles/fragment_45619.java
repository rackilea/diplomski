import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestRailReporter.class)
public class SampleTestCase {

  @Test
  @Tcms(id = "TESTRAIL-1")
  public void testMethod() {
    Assert.assertTrue(true);
  }

  @Test(dataProvider = "dp")
  @Tcms(id = "TESTRAIL-2")
  public void dataDrivenTestWithSomeFailures(int i) {
    if (i % 2 == 0) {
      Assert.fail("simulating a failure");
    }
  }

  @Test(dataProvider = "dp")
  @Tcms(id = "TESTRAIL-3")
  public void dataDrivenTestWithNoFailures(int i) {
    Assert.assertTrue(i >= 0);
  }

  @DataProvider(name = "dp")
  public Object[][] getData() {
    return new Object[][] {{1}, {2}, {3}};
  }
}