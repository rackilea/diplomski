log4j.rootLogger=DEBUG,file
log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.File=D:\\ProjectXXX\\src\\Selenium.logs
log4j.appender.file.maxFileSize=900KB
log4j.appender.file.maxBackupIndex=5
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{ABSOLUTE} %5p %c<strong>{1}</strong>:%L - %m%n
log4j.appender.file.Append=false