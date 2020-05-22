import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestRailReporter implements IInvokedMethodListener {
  private Map<String, Boolean> resultTracker = new ConcurrentHashMap<>();

  @Override
  public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    String key = testResult.getInstanceName() + "." + method.getTestMethod().getMethodName();
    resultTracker.putIfAbsent(key, Boolean.TRUE);
  }

  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    Tcms tcms =
        method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(Tcms.class);
    // Only report those tests to TestRail wherein our annotation is found.
    if (tcms == null) {
      return;
    }
    if (method.getTestMethod().isDataDriven()) {
      // For data driven tests we need a different logic
      String key = testResult.getInstanceName() + "." + method.getTestMethod().getMethodName();
      if (method.getTestMethod().hasMoreInvocation()) {
        Boolean result = resultTracker.get(key);
        result = result && (testResult.getStatus() == ITestResult.SUCCESS);
        resultTracker.put(key, result);
        return;
      }
      postResultsToTestRail(tcms, resultTracker.get(key));
    } else {
      postResultsToTestRail(tcms, testResult.getStatus() == ITestResult.SUCCESS);
    }
  }

  private void postResultsToTestRail(Tcms tcms, boolean pass) {
    String testCaseId = tcms.id();
    // Write logic here that takes care of posting results to the TCMS system
    System.err.println("Test case Id [" + testCaseId + "] passed ? " + pass);
  }
}