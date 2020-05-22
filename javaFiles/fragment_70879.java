public class LogWrapper {
    private Class loggerClass;
    private Logger logger;

    public LogWrapper(Class loggerClass) {
        this.loggerClass = loggerClass; //lazy logging context creation (to avoid issues with static instances in EJBs which get loaded on startup before logging ctx name is actually set)
    }

    /**
     * For lazy init of logger, on first actual use, so the logger context will be correctly set even when used by EJBs (loaded by classloader too soon, before logging context is actually set)
     */
    private Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger(loggerClass);
            loggerClass = null;
        }
        return logger;
    }

    public void info(String message) {
        getLogger().info(message);
    }