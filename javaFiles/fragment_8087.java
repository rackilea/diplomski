import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestInterceptor implements ITestListener {
    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTestSuccess(ITestResult arg0) {
        System.out.println(" Can perform CheckDifference operation here.");

    }

}