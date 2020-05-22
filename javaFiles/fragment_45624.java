import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestRailReporter2.class)
public class AnotherSampleTestCase {

  @Test
  @Tcms(id = "TESTRAIL-1")
  public void simpleTestMethod() {
    Assert.assertTrue(true);
  }

  @Test(dataProvider = "dp")
  public void dataDrivenTestMethod(TestData data) {
    Assert.assertFalse(data.getData().trim().isEmpty());
  }

  @DataProvider(name = "dp")
  public Object[][] getData() {
    return new Object[][] {
      {new TestData("TESTRAIL-2", "Jack")},
      {new TestData("TESTRAIL-3", "")},
      {new TestData("TESTRAIL-4", "Daniels")}
    };
  }
}