public class MyRunner extends BlockJUnit4ClassRunner {
    private MySuite suite;

    public MyRunner(Class<?> klass, MySuite suite) throws InitializationError {
        super(klass);
        this.suite = suite;
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
        Description description= describeChild(method);
        if (method.getAnnotation(Ignore.class) != null) {
            notifier.fireTestIgnored(description);
        } else {
            // call suite.getContext()
            // call setContext() in class
            runLeaf(methodBlock(method), description, notifier);
            // call getContext() in class
            // call suite.setContext()
        }
    }
}