public class DBHandler extends Handler {

    public DBHandler() {
        LogManager m = LogManager.getLogManager();
        String p = getClass().getName();
        String v = m.getProperty(p + ".level");
        try {
            if (v != null) {
                super.setLevel(Level.parse(v));
            }
        } catch (RuntimeException re) {
            reportError(v, re, ErrorManager.OPEN_FAILURE);
        }
        //@todo create code to parse filter, formatter, encoding, etc.
    }

    @Override
    public void close() throws SecurityException {
    }

    @Override
    public void flush() {
    }

    @Override
    public void publish(LogRecord logRecord) {
        if (isLoggable(logRecord)) {
            try {
                //SQL call to insert onDB
            } catch (Exception e) {
                reportError("", e, ErrorManager.WRITE_FAILURE);
            }
        }
    }
}