public void setLevel(Level level) {
    LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
    Configuration conf = ctx.getConfiguration();
    LoggerConfig root = conf.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
    root.setLevel(level);
    LoggerConfig named = conf.getLoggerConfig("com.cf.re");
    named.setLevel(level);
    ctx.updateLoggers(conf);
}