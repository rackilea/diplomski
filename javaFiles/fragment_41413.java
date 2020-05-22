@Override
public void testFinished(Description description) throws Exception {
    super.testFinished(description);
    try {
        Mockito.validateMockitoUsage();
    } catch(Throwable t) {
        notifier.fireTestFailure(new Failure(description, t));
    }
}