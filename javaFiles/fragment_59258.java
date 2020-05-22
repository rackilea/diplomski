log4j.rootLogger=ERROR, logfile

log4j.appender.logfile=org.apache.log4j.DailyRollingFileAppender
log4j.appender.logfile.datePattern='-'dd'.log'
log4j.appender.logfile.File=log/radius-prod.log
log4j.appender.logfile.layout=org.apache.log4j.PatternLayout
log4j.appender.logfile.layout.ConversionPattern=%-6r %d{ISO8601} %-5p %40.40c %x - %m\n

log4j.logger.foo.bar.Baz=DEBUG, myappender
log4j.additivity.foo.bar.Baz=false

log4j.appender.myappender=org.apache.log4j.DailyRollingFileAppender
log4j.appender.myappender.datePattern='-'dd'.log'
log4j.appender.myappender.File=log/access-ext-dmz-prod.log
log4j.appender.myappender.layout=org.apache.log4j.PatternLayout
log4j.appender.myappender.layout.ConversionPattern=%-6r %d{ISO8601} %-5p %40.40c %x - %m\n