name=PropertiesConfig
property.filename = logs
appenders = console, file

appender.console.type = Console
appender.console.name = STDOUT
appender.console.layout.type = PatternLayout
appender.console.layout.pattern = [%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n

appender.file.type = File
appender.file.name = LOGFILE
appender.file.fileName=${filename}/propertieslogs.log
appender.file.layout.type=PatternLayout
appender.file.Append=true
appender.file.layout.pattern=[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n
loggers=file1,file2,file3,file4
logger.file1.name=test
logger.file1.level = debug
logger.file1.appenderRefs = file
logger.file1.appenderRef.file.ref = LOGFILE

logger.file2.name=metadataservice.impl
logger.file2.level = debug
logger.file2.appenderRefs = file
logger.file2.appenderRef.file.ref = LOGFILE

logger.file3.name=db.connector
logger.file3.level = debug
logger.file3.appenderRefs = file
logger.file3.appenderRef.file.ref = LOGFILE

    logger.file4.name=metadatareader
    logger.file4.level = debug
    logger.file4.appenderRefs = file
    logger.file4.appenderRef.file.ref = LOGFILE

rootLogger.level = debug
rootLogger.appenderRefs = stdout
rootLogger.appenderRef.stdout.ref = STDOUT