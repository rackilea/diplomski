# Create ROOT logger(main logger) with level INFO, and add to it 2 appenders:
# FILE_INFO, FILE_WARN. This means that all loggers by default will writes messages
# in this 2 file appenders, with level INFO or higher
log4j.rootLogger=INFO, FILE_INFO, FILE_WARN

######## LEVELS:
# Set logging level to WARN for all classes and subclasses in package 
# com.taxware.mgmt.CustomerManager
log4j.category.com.taxware.mgmt.CustomerManager=WARN

######## APPENDERS:

# FILE_INFO
# Type of appender
log4j.appender.FILE_INFO=org.apache.log4j.RollingFileAppender
# File where to save all messages
log4j.appender.FILE_INFO.File=D:/CSVExportLogs/CSVExportLogFile-INFO.log
# Max file size, after that will be created new log file, and old file will be renamed
log4j.appender.FILE_INFO.MaxFileSize=100KB
# Maximum amount of old log files.
log4j.appender.FILE_INFO.MaxBackupIndex=100
# Patter of messages.
log4j.appender.FILE_INFO.layout=org.apache.log4j.PatternLayout
log4j.appender.FILE_INFO.layout.ConversionPattern=%d{ISO8601} [%-5p][%-24.24t][%32.32c] - %m%n
# Custom level for appender. In this file will be add only messages with level INFO or highter
log4j.appender.FILE_INFO.Threshold=INFO

# FILE_WARN file appender
log4j.appender.FILE_WARN=org.apache.log4j.RollingFileAppender
log4j.appender.FILE_WARN.File=D:/CSVExportLogs/CSVExportLogFile-WARN.log
log4j.appender.FILE_WARN.MaxFileSize=50KB
log4j.appender.FILE_WARN.MaxBackupIndex=10
log4j.appender.FILE_WARN.layout=org.apache.log4j.PatternLayout
log4j.appender.FILE_WARN.layout.ConversionPattern=%d{ISO8601} [%-5p][%-24.24t][%32.32c] - %m%n
# Custom level for appender. In this file will be add only messages with level WARN or highter
log4j.appender.FILE_WARN.Threshold=WARN