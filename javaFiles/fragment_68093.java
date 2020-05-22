public class LogLevelDemo {

    private static final Logger LOG = Logger.getLogger(LogLevelDemo.class);

    public void log() {
        LOG.fatal("This is fatal.");
        LOG.error("This is error.");
        LOG.warn("This is warn.");
        LOG.info("This is info.");
        LOG.debug("This is debug.");
        LOG.trace("This is trace.");
    }

    public static void main(String[] args) {
        LogLevelDemo lld = new LogLevelDemo();
        lld.log();
    }

}