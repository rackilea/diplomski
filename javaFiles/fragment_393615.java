@Rule
public TestRule watchman = new TestWatcher() {

    @Override
    protected void succeeded(final Description description) {
        logger.info(String.format("Success: %s", description));
    }

    @Override
    protected void failed(final Throwable e, final Description description) {
        logger.info(String.format("Failed: %s", description), e);
    }

    @Override
    protected void starting(final Description description) {
        logger.info(String.format("Starting: %s", description));
    }

    @Override
    protected void finished(final Description description) {
        logger.info(String.format("Finished: %s", description));
    }

    };