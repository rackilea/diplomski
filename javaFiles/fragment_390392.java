for (AppenderFactory output : getAppenders()) {
        Appender<ILoggingEvent> build = output.build(loggerContext, name, null);
        if(output instanceof MappedLogger && ((MappedLogger) output).getLoggerName() != null) {
            String appenderName = ((MappedLogger) output).getLoggerName();
            String loggerName = loggerMappings.get(appenderName);
            Logger logger = this.loggerContext.getLogger(loggerName);
            logger.addAppender(build);
        } else {
            root.addAppender(build);
        }
    }