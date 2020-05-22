log4j.rootCategory=DEBUG, LOGFILE_ENGINE

log4j.category.packageName.className = DEBUG, packageName.className.syncLogger
log4j.additivity.packageName.className= false

log4j.appender.LOGFILE_ENGINE=org.apache.log4j.RollingFileAppender
log4j.appender.LOGFILE_ENGINE.File=${catalina.home}/logs/file1.log
.....................

log4j.appender.packageName.className.syncLogger=org.apache.log4j.RollingFileAppender
log4j.appender.packageName.className.syncLogger.File=${catalina.home}/logs/file2.log
log4j.appender.packageName.className.syncLogger.Threshold=DISASTER#packageName.SyncLogLevel
.....................