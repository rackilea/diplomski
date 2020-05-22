public class ExceptionHandlingThreadGroup extends ThreadGroup {
    private UncaughtExceptionHandler uncaughtExceptionHandler;

    public ExceptionHandlingThreadGroup(String name) {
        super(name);
    }
    public ExceptionHandlingThreadGroup(ThreadGroup parent, String name) {
        super(parent, name);
    }

    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.uncaughtExceptionHandler;
    }
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (this.uncaughtExceptionHandler != null)
            this.uncaughtExceptionHandler.uncaughtException(t, e);
        else
            super.uncaughtException(t, e);
    }
}