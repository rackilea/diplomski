# 'status' refers to log messages from Log4j2 itself
monitorInterval = 30
status = warn

property.loglevel.catalina = info
property.loglevel.localhost = info

property.layoutPattern.catalina = %d %-5p [%t] %-22.22c{1} %m%n
property.layoutPattern.localhost = %d %-5p [%t] %-30.30c{1} %m%n

# Roll-over the logs once per month using CronTriggerPolicy.

property.fileDatePattern.catalina = %d{yyyy-MM}
property.fileDatePattern.localhost = %d{yyyy-MM}

property.cronTriggerSchedule.catalina = 0 0 0 1 * ?
property.cronTriggerSchedule.localhost = 0 0 0 1 * ?

## Appenders

# N.B.: - No need to specify 'appenders = CATALINA, LOCALHOST, CONSOLE'
#         since these identifiers don't contain '.' characters.
#       - The sub-component identifiers 'policies' and 'cron' are arbitrarily
#         chosen; the actual type is specified via the 'type' attribute.
#       - 'DirectWriteRolloverStrategy' is used automatically since no 'fileName' specified.

appender.CATALINA.type = RollingFile
appender.CATALINA.name = RollingFile-CATALINA
appender.CATALINA.filePattern = ${sys:catalina.base}/logs/catalina.${fileDatePattern.catalina}.log
appender.CATALINA.layout.type = PatternLayout
appender.CATALINA.layout.pattern = ${layoutPattern.catalina}
appender.CATALINA.policies.type = Policies
appender.CATALINA.policies.cron.type = CronTriggeringPolicy
appender.CATALINA.policies.cron.schedule = ${cronTriggerSchedule.catalina}
appender.CATALINA.policies.cron.evaluateOnStartup = true
appender.CATALINA.filePermissions = rw-r-----
appender.CATALINA.fileOwner = tomcat
appender.CATALINA.fileGroup = adm

appender.LOCALHOST.type = RollingFile
appender.LOCALHOST.name = RollingFile-LOCALHOST
appender.LOCALHOST.filePattern = ${sys:catalina.base}/logs/localhost.${fileDatePattern.localhost}.log
appender.LOCALHOST.layout.type = PatternLayout
appender.LOCALHOST.layout.pattern = ${layoutPattern.localhost}
appender.LOCALHOST.policies.type = Policies
appender.LOCALHOST.policies.cron.type = CronTriggeringPolicy
appender.LOCALHOST.policies.cron.schedule = ${cronTriggerSchedule.localhost}
appender.LOCALHOST.policies.cron.evaluateOnStartup = true
appender.LOCALHOST.filePermissions = rw-r-----
appender.LOCALHOST.fileOwner = tomcat
appender.LOCALHOST.fileGroup = adm

# Uncomment if you want to keep logging to catalina.out after Log4j2 takes over.

#appender.CONSOLE.type = Console
#appender.CONSOLE.name = STDOUT
#appender.CONSOLE.layout.type = PatternLayout

## Configure which loggers log to which appenders

rootLogger.level = ${loglevel.catalina}
rootLogger.appenderRef.CATALINA.ref = RollingFile-CATALINA
#rootLogger.appenderRef.stdout.ref = STDOUT

# Here, the identifier does contain '.' characters, so we must specify the list.
loggers = org.apache.catalina.core.ContainerBase.[Catalina].[localhost]

logger.org.apache.catalina.core.ContainerBase.[Catalina].[localhost].name = LOCALHOST
logger.org.apache.catalina.core.ContainerBase.[Catalina].[localhost].level = ${loglevel.localhost}
logger.org.apache.catalina.core.ContainerBase.[Catalina].[localhost].appenderRef.LOCALHOST.ref = RollingFile-LOCALHOST