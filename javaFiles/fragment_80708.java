log4j.logger.devpinoyLogger=DEBUG, dest1
log4j.appender.dest1=org.apache.log4j.RollingFileAppender
log4j.appender.dest1.maxFileSize=900KB
log4j.appender.dest1.maxBackupIndex=6
log4j.appender.dest1.layout=org.apache.log4j.PatternLayout
log4j.appender.dest1.layout.ConversionPattern=%d{dd/MM/yyyy HH:mm:ss} %c %m%n
log4j.appender.dest1.File=D:\\ ProjectXXX\\src\\Manual.logs
log4j.appender.dest1.Append=false