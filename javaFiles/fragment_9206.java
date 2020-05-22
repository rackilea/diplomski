interface ILogger {
    Logger logger = LoggerFactory.getLogger(ILogger.class.getName());

    default void debug(String message) {
        logger.debug(message);
    }
}