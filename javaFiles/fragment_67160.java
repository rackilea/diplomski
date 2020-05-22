public class MyTestListener extends TestListenerAdapter {

  @Override
  public void onTestFailure(ITestResult tr) {
    log("FAIL: ", tr);
  }

  @Override
  public void onTestSkipped(ITestResult tr) {
    log("SKIPPED: ", tr);
  }

  @Override
  public void onTestSuccess(ITestResult tr) {
    log("PASSED: ", tr);
  }

  private static void log(String prefix, ITestResult tr) {
    System.out.println(prefix + tr.getName() + "(" + Arrays.asList(tr.getParameters()) + ")");
  }
}