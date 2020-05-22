log4j.rootLogger=FATAL, fatalFile
    log4j.appender.fatalFile=org.apache.log4j.RollingFileAppender
    log4j.appender.fatalFile.file=log/fatal.log
    log4j.appender.fatalFile.MaxFileSize=10MB
    log4j.appender.fatalFile.MaxBackupIndex=10
    log4j.appender.fatalFile.layout=org.apache.log4j.PatternLayout
    log4j.appender.fatalFile.layout.conversionPattern=%d{[dd.MM.yyyy] [HH:mm:ss]} %p [%t] %c (%F:%L) - %m%n