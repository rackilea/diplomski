@Test tester() {
    Logger logger = Logger.getLogger("my junit-test logger");
    LogHandler handler = new LogHandler();
    handler.setLevel(Level.ALL);
    logger.setUseParentHandlers(false);
    logger.addHandler(handler);
    logger.setLevel(Level.ALL);