log4j.rootLogger=TRACE, stdout

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d [%5F:%t:%L] - %m%n

log4j.appender.animalLogger=org.apache.log4j.FileAppender
log4j.appender.animalLogger.File=animal.log
log4j.appender.animalLogger.layout=org.apache.log4j.PatternLayout
log4j.appender.animalLogger.layout.ConversionPattern=%d [%5F:%t:%L] - %m%n

log4j.category.animalLogger=DEBUG, animalLogger
log4j.additivity.animalLogger=false

log4j.category.foodlLogger=DEBUG, stdout
log4j.additivity.foodlLogger=false

static final Logger animalLogger = Logger.getLogger("animalLogger");
static final Logger foodlLogger = Logger.getLogger("foodlLogger");