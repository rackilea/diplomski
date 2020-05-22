import java.util.Arrays;
import org.testng.Assert;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestReporter.class)
public class TestclassExample implements IHookable {
  private boolean hasFailures = false;

  @Test(dataProvider = "getData")
  public void test(String data) {
    if (data.equals("Three")) {
      Assert.fail("Simulating a failure for [" + data + "]");
    }
    System.err.println("executing test  for data [" + data + "]");
  }

  @DataProvider
  public Object[][] getData() {
    return new Object[][] {{"One"}, {"Two"}, {"Three"}, {"Four"}, {"Five"}};
  }

  @Override
  public void run(IHookCallBack callBack, ITestResult testResult) {
    if (hasFailures) {
      testResult.setStatus(ITestResult.FAILURE);
    } else {
      callBack.runTestMethod(testResult);
      if (testResult.getThrowable() != null) {
        hasFailures = true;
      }
    }
  }

  public static class TestReporter implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
      String msg =
          String.format(
              "[%s()] failed for data %s",
              result.getMethod().getMethodName(), Arrays.toString(result.getParameters()));
      System.err.println(msg);
    }
  }
}