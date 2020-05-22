//This class is not thread safe, and will give unpredictable results
//if you multiple <test> tags running.
import org.testng.ITestContext;
import org.testng.ITestListener;

public class LocalListener implements ITestListener {

  private static LocalListener instance;
  private ITestContext testContext;

  private static void setInstance(LocalListener obj) {
    instance = obj;
  }

  public static LocalListener getInstance() {
    return instance;
  }

  public LocalListener() {
    setInstance(this);
  }

  @Override
  public void onStart(ITestContext context) {
    this.testContext = context;
  }

  public ITestContext getTestContext() {
    return testContext;
  }
}