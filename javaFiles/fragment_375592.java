log4j.rootLogger=A,B

#/A
log4j.logger.A=,A
log4j.additivity.A=false
log4j.appender.A=org.apache.log4j.RollingFileAppender
log4j.appender.A.File=logs/MyRestService_A.log
log4j.appender.A.MaxFileSize=5MB
log4j.appender.A.MaxBackupIndex=5
log4j.appender.A.layout=org.apache.log4j.PatternLayout
log4j.appender.A.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %m%n

#/B
log4j.logger.B=,B
log4j.additivity.B=false
log4j.appender.B=org.apache.log4j.RollingFileAppender
log4j.appender.B.File=logs/MyRestService_B.log
log4j.appender.B.MaxFileSize=5MB
log4j.appender.B.MaxBackupIndex=5
log4j.appender.B.layout=org.apache.log4j.PatternLayout
log4j.appender.B.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %m%n