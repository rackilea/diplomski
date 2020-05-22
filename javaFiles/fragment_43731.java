private static void configureLogger(String logDir, String logLevel, String logbackConf){
    LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
    try {
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(context);
        context.reset();
        context.putProperty("LOG_DIR", logDir);
        context.putProperty("LOG_LEVEL", logLevel);
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(LOGBACK_CONF);
        configurator.doConfigure(is);
    } catch (JoranException je) {
        LOG.warn("Can not configure logger. Continue to execute the command.", je);
    }
    StatusPrinter.printInCaseOfErrorsOrWarnings(context);
}