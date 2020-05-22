log4j.rootLogger=INFO, stdout

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %t %c:%L - %m%n

log4j.category.com.github.flowersinthesand=TRACE
log4j.category.org.atmosphere=TRACE