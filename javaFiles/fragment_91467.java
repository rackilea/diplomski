log4j.rootLogger=ERROR, stdout

log4j.logger.logGen=DEBUG, KAFKA

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L %% %m%n

log4j.appender.KAFKA=kafka.producer.KafkaLog4jAppender
log4j.appender.KAFKA.topic=LOG
log4j.appender.KAFKA.brokerList=localhost:9092
log4j.appender.KAFKA.compressionType=none
log4j.appender.KAFKA.requiredNumAcks=0
log4j.appender.KAFKA.syncSend=true
log4j.appender.KAFKA.layout=org.apache.log4j.PatternLayout
log4j.appender.KAFKA.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L %% - %m%n