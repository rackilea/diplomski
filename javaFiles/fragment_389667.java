# root logger
 log4j.rootLogger = INFO, stdout

# category filters
log4j.category.org.hibernate.SQL=TRACE

# appenders
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{ISO8601} %-5p %F:%L - %m%n