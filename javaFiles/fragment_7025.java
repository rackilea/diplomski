import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MyUnitTestClass implements IHookable {
    private List<String> errorCodes = Arrays.asList("ERR100909", "ERR100");

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        Throwable t = testResult.getThrowable();
        if (t != null) {
            t = t.getCause();
        }
        boolean shouldFail = (t instanceof CustomException && errorCodes.contains(((CustomException) t).getErrorCode()));
        if (!shouldFail) {
            testResult.setThrowable(null);
            testResult.setStatus(ITestResult.SUCCESS);
        }
    }

    @Test
    public void test1() throws CustomException {
        throw new CustomException("test", "ERR100", new Throwable());
    }

    @Test
    public void test2() throws CustomException {
        throw new CustomException("test", "ERR500", new Throwable());
    }
}