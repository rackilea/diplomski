name=PropertiesConfig
#output folder
property.filename = d:\\logs
appenders = console, debugLoggerAppender, commonLoggerAppender, errorLoggerAppender

appender.console.type = Console
appender.console.name = STDOUT
appender.console.layout.type = PatternLayout
appender.console.layout.pattern = %d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

#common appender
appender.commonLoggerAppender.type = File
appender.commonLoggerAppender.name = RollingFile
appender.commonLoggerAppender.fileName=${filename}/log.log
appender.commonLoggerAppender.layout.type=PatternLayout
appender.commonLoggerAppender.layout.pattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

#error appender
appender.errorLoggerAppender.type = RandomAccessFile
appender.errorLoggerAppender.name = RandomAccessFile
appender.errorLoggerAppender.fileName=${filename}/error.log
appender.errorLoggerAppender.layout.type=PatternLayout
appender.errorLoggerAppender.layout.pattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
#using LevelRangeFilter to only log error levels.
appender.errorLoggerAppender.filter.threshold.type = LevelRangeFilter
appender.errorLoggerAppender.filter.threshold.minLevel = error
appender.errorLoggerAppender.filter.threshold.maxLevel = error

#debug appender
appender.debugLoggerAppender.type = File
appender.debugLoggerAppender.name = LOGFILE
appender.debugLoggerAppender.fileName=${filename}/debug.log
appender.debugLoggerAppender.layout.type=PatternLayout
appender.debugLoggerAppender.layout.pattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
#using LevelRangeFilter to only log debug levels.
appender.debugLoggerAppender.filter.threshold.type = LevelRangeFilter
appender.debugLoggerAppender.filter.threshold.minLevel = debug
appender.debugLoggerAppender.filter.threshold.maxLevel = debug



# creating only one logger, we can use this with multiple appenders.
loggers=fileLogger
# this is package name. This package and all of it's child packages will use this logger
logger.fileLogger.name=com.fis.bsa
# logger base level
logger.fileLogger.level = debug
logger.fileLogger.appenderRefs = debugLoggerAppender,commonLoggerAppender, errorLoggerAppender
logger.fileLogger.appenderRef.debugLoggerAppender.ref = LOGFILE
logger.fileLogger.appenderRef.commonLoggerAppender.ref = RollingFile
logger.fileLogger.appenderRef.errorLoggerAppender.ref = RandomAccessFile

rootLogger.level = info
#rootLogger.appenderRefs = stdout
rootLogger.appenderRef.stdout.ref = STDOUT