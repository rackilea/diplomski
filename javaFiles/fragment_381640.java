public class MyRule extends ExternalResource {
    private String testName;

    @Override
    public Statement apply(Statement base, Description description) {
        // Store the test name
        testName = description.getMethodName();
        return super.apply(base, description);
    }

    public void before() {
        // Use it in the before method
        System.out.println("Test name is " + testName);
    }
}