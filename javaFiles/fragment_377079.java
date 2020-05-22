package com.qmetry.qaf.example.test;
...
public class StopRunListener implements IInvokedMethodListener {
   private static boolean hasFailure=false;

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        String[] groups = testResult.getMethod().getGroups();

        if(hasFailure && Arrays.asList(groups).contains("Test2")) {
            throw new SkipException("Stop execution due to failure");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        String[] groups = testResult.getMethod().getGroups();

        if(!testResult.isSuccess() && Arrays.asList(groups).contains("Test1")) {
            hasFailure=true;
        }

    }

}