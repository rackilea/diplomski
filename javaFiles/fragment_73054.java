public class ManyTestCases {
    @Test
    public void testMethod1() {
        runTest("http://www.google.com");
    }

    @Test
    public void testMethod2() {
        runTest("http://www.yahoo.com");
    }

    private void runTest(String url) {
        ChromeDriver cd = new ChromeDriver();
        EventFiringWebDriver driver = new EventFiringWebDriver(cd);
        LogAwareWebDriverEventListener listener = new LogAwareWebDriverEventListener();
        String outputFolder = Reporter.getCurrentTestResult().getTestContext().getSuite().getOutputDirectory();
        listener.bindLogName(Reporter.getCurrentTestResult().getName(), outputFolder);
        driver.register(listener);
        driver.get(url);
        driver.quit();
        listener.unbind();
    }
}