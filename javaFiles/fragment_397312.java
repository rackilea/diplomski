public static final Logger LOG = LogManager.getLogger(YourClass.class);

public String getLoggerFileName() {
  org.apache.logging.log4j.core.Logger loggerImpl = (org.apache.logging.log4j.core.Logger) LOG;
  Appender appender = loggerImpl.getAppenders().get("RollingFile");
  // Unfortunately, File is no longer an option to return, here.
  return ((RollingFileAppender) appender).getFileName();
}