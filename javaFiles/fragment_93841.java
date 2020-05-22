log4j.logger.infoNTS=DEBUG, file, nConsole
log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.file=log/spider.cisco.log
log4j.appender.file.MaxFileSize=1GB
log4j.appender.file.MaxBackupIndex=10
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.conversionPattern=%d{[dd.MM.yyyy] [HH:mm:ss]} %p [%t] %c (%F:%L) - %m%n

log4j.appender.nConsole= org.apache.log4j.ConsoleAppender
log4j.appender.nConsole.target=System.out
log4j.appender.nConsole.layout = org.apache.log4j.PatternLayout
log4j.appender.nConsole.layout.ConversionPattern = %d{[dd.MM.yyyy] [HH:mm:ss]} %p [%t] %c (%F:%L) - %m%n