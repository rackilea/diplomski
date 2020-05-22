public class MedSlaveImpl implements MedSlaveInt {
    private static Logger logger;

    // Package visible to override it in the tests.
    Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger(MedSlaveImpl.class);
        }
        return logger;
    }

    @Override
    public void enterMode() {
        // All calls to the logger via getLogger() method.
        getLogger().info("muting the Manager");
    }
}