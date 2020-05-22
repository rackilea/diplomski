public class MyLogger {
    final Logger target;

    public MyLogger(Logger target) {
        this.target = target;
    }

    public void error(Object message) {
        target.error(message);
    }

    public void debug(Object message) {
        target.debug(message);
    }

    //...

    public String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}