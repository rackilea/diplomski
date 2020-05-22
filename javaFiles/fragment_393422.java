log4j.appender.customLog=org.apache.log4j.FileAppender
log4j.appender.customLog.File=/home/user/TEMP/Spark/sparkapp.log
log4j.appender.customLog.layout=org.apache.log4j.PatternLayout
log4j.appender.customLog.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss.SSS} %-5p %c{1}:%L - %m%n

log4j.category.customLog=INFO, debugLog
log4j.additivity.customLog=false