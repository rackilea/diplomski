import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class SampleListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        Object[] parameters = testResult.getParameters();
        if (parameters != null) {
            printer("beforeInvocation", method, parameters);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        Object[] parameters = testResult.getParameters();
        if (parameters != null) {
            printer("afterInvocation", method, parameters);
        }
    }

    private void printer(String prefix, IInvokedMethod method, Object[] parameters) {
        String msg = String.format("Running %s() for method %s() with parameters: %s", prefix,
                method.getTestMethod().getMethodName(),
                Arrays.toString(parameters));
        System.err.println(msg);
    }
}