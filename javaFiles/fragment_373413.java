log4j.rootLogger=info,gyani
log4j.appender.gyani=org.apache.log4j.RollingFileAppender
log4j.appender.gyani.File=/home/gyani/myserverlog.log
log4j.appender.gyani.Append=true
log4j.appender.gyani.MaxFileSize=100000KB
log4j.appender.gyani.MaxBackupIndex=10
log4j.appender.gyani.layout=org.apache.log4j.PatternLayout
log4j.appender.gyani.layout.ConversionPattern=[%d{MMM d HH:mm:ss yyyy}] [%-5p] [%c]: %m%n