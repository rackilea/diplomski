log4j.debug=TRUE

log4j.logger.com.XXX.RemoteCacheManager=FATAL, Logs
log4j.logger.com.XXX.RedisCacheImpl=FATAL, Logs
log4j.logger.com.XXX.utils=DEBUG, TimeItLogs
log4j.logger.com.XXX=DEBUG, Logs

log4j.logger.org.hibernate=INFO, Logs
log4j.logger.org.springframework=INFO, Logs
log4j.logger.org.apache.velocity=ERROR, Logs
log4j.logger.org.apache.commons=ERROR, Logs
log4j.logger.org.apache.tiles=ERROR, Logs

log4j.appender.Logs=org.apache.log4j.RollingFileAppender
log4j.appender.Logs.File=${catalina.base}/logs/XXX.log
log4j.appender.Logs.MaxFileSize=10MB
log4j.appender.Logs.MaxBackupIndex=50
log4j.appender.Logs.layout=org.apache.log4j.PatternLayout
log4j.appender.Logs.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %p %t %c %m %n