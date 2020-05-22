public LoggerTest() {
    BasicLogger logger = new BasicLogger();
    Logger htmlLogger = new HTMLLogger(new BasicLogger());
    Logger xmlAndHtmlLogger = new XMLLogger(new HTMLLogger());
    logger.log("Basic Logger log");
    htmlLogger.log("HTML Logging");
    xmlAndHtmlLogger.log("I am Both HTML and XML logging");
}