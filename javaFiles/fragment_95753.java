private static final MyLogger logger = new MyLogger(LogManager.getRootLogger());

public void someMethod() {
    try {
        //
    }
    catch (Exception e) {
        logger.error(logger.getStackTrace(e));
    }
}