public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestStart(ITestResult tr) {
       super.onTestStart(tr);
       Object[] params = tr.getParameters();
       String a = (String)params[0];
       int b = (int)params[1];
       //Add whatever you want to do before the test case starts
    }
 }