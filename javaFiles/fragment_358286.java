public class RetryAnalyzer implements IRetryAnalyzer {

    @Override
    public boolean retry(ITestResult result) {
        boolean shouldRetry = // business logic
        if(shouldRetry) {
            return true;
        }
        return false;
    }
}