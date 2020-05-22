import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestRailReporter2 implements IInvokedMethodListener {

  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    if (method.getTestMethod().isDataDriven()) {
      //Data driven tests need to be handled differently
      Object[] parameters = testResult.getParameters();
      if (parameters.length != 1) {
        //If theres more than one parameter, then dont do anything.
        return;
      }
      Object parameter = parameters[0];
      if (!(parameter instanceof Tcms)) {
        //If the parameter doesnt implement our interface dont do anything
        return;
      }
      postResultsToTestRail(
          (Tcms) parameter, testResult.getStatus() == ITestResult.SUCCESS, parameter.toString());
    } else {
      Tcms tcms =
          method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(Tcms.class);
      if (tcms == null) {
        return;
      }
      postResultsToTestRail(tcms, testResult.getStatus() == ITestResult.SUCCESS);
    }
  }

  private void postResultsToTestRail(Tcms tcms, boolean pass) {
    String testCaseId = tcms.id();
    // Write logic here that takes care of posting results to the TCMS system
    System.err.println("Test case Id [" + testCaseId + "] passed ? " + pass);
  }

  private void postResultsToTestRail(Tcms tcms, boolean pass, String param) {
    String id = tcms.id();
    // Write logic here that takes care of posting results to the TCMS system
    System.err.println("Test case Id [" + id + "] with parameter [" + param + "] passed ? " + pass);
  }
}