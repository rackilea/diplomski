abstract class Retrieable<I,O> {
    private final LogLevel logLevel;

    protected Retrieable(LogLevel loglevel) {
        this.logLevel = loglevel;
    }

    protected abstract O call(I input);

    // subclasses may override to perform custom logic.
    protected void handle(RuntimeException e) {
        // log the exception. 
    }

    public O execute(I input) {
        for (int iteration = 1; ; iteration++) {
            try {
                return call(input);
            } catch (RuntimeException e) {
                if (iteration == helper.getNumberOfRetries()) {
                    throw e;
                } else {
                    handle();
                    utilities.defaultDelayForIteration(iteration);
                }
            }
        }
    }
}