public class ListenerLogger implements ITestListener
{
  private static final Logger LOG = LoggerFactory.getLogger(ListenerLogger.class);

  @Override
  public void onTestStart(ITestResult result)
  {
    LOG.info("Starting {}.{} with parameters {}", result.getTestClass().getName(), result.getTestName(), result.getParameters());
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult)
  {
    LOG.info("Test successful");
  }

  // This belongs to ITestListener and will execute only on the event of fail test
  public void onTestFailure(ITestResult result)
  {
    LOG.error("Test failed!", result.getThrowable());
  }
  ...
}