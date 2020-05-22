public static final Logger LOG = Logger.getLogger(YourClass.class);

public File getLoggerFile() {
  Appender appender = LOG.getAppender("RollingFile");
  return appender.getFile();
}