String logFolderName = "newfoldername";
String logFilePath = "E:/Logging/" + logFolderName + "/error.log";

Logger logger = Logger.getRootLogger();
FileAppender appender = (FileAppender)logger.getAppender("theFileAppender");
appender.setFile(logFilePath);
appender.activateOptions();