log4j.rootLogger=INFO, stdout, myAppender

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

log4j.appender.myAppender=org.apache.log4j.RollingFileAppender
log4j.appender.myAppender.Threshold=WARN
log4j.appender.myAppender.File=\\clientexceptionlog.txt
log4j.appender.myAppender.MaxFileSize=2048KB
log4j.appender.myAppender.layout=org.apache.log4j.PatternLayout
log4j.appender.myAppender.layout.ConversionPattern=%d [%t] %-5p %c - %m%n