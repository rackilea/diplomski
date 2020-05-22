log4j.rootLogger = INFO,fileAppender
log4j.logger.FOO=DEBUG,FOOAppender,fileAppender
log4j.additivity.FOO=false 

log4j.appender.FOOAppender = org.apache.log4j.RollingFileAppender 
log4j.appender.FOOAppender.layout = org.apache.log4j.PatternLayout
log4j.appender.FOOAppender.layout.ConversionPattern = %d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
log4j.appender.FOOAppender.File = foo.log

log4j.appender.fileAppender=org.apache.log4j.FileAppender
log4j.appender.fileAppender.File=log.log
log4j.appender.fileAppender.layout=org.apache.log4j.PatternLayout
log4j.appender.fileAppender.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n