public class DynamicTimeOutSample {

  private final long timeout;
  private final long waitTime;

  @DataProvider
  public static Object[][] dp() {
    return new Object[][]{
        new Object[]{ 1_000, 2_000 },
        new Object[]{ 3_000, 6_000 },
    };
  }

  @Factory(dataProvider = "dp")
  public DynamicTimeOutSample(long timeout, long waitTime) {
    this.timeout = timeout;
    this.waitTime = waitTime;
  }

  @BeforeMethod
  public void setUp(ITestContext context) {
    ITestNGMethod currentTestNGMethod = null;
    for (ITestNGMethod testNGMethod : context.getAllTestMethods()) {
      if (testNGMethod.getInstance() == this) {
        currentTestNGMethod = testNGMethod;
        break;
      }
    }
    currentTestNGMethod.setTimeOut(timeout);
  }

  @Test
  public void test() throws InterruptedException {
    Thread.sleep(waitTime);
  }
}