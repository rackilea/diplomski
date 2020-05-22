# Set root logger level to INFO and its only appender to demoappender
log4j.rootLogger=INFO, demoappender

# demoappender is set to be a ConsoleAppender.
log4j.appender.demoappender=org.apache.log4j.ConsoleAppender
# log4j.appender.demoappender=System.out                    <-- Remove this line

# demoappender uses PatternLayout.
log4j.appender.demoappender.layout=org.apache.log4j.PatternLayout
log4j.appender.demoappender.layout.ConversionPattern=%d{ABSOLUTE} %5p %c:%L - %m%n