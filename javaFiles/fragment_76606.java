# Additional loggers to configure (the root logger is always configured)
loggers=my.testpackage.MyClass,my

logger.level=INFO
logger.handlers=CONSOLE

logger.my.testpackage.MyClass.level=WARN

logger.my.level=WARN

handler.CONSOLE=org.jboss.logmanager.handlers.ConsoleHandler
handler.CONSOLE.level=INFO
handler.CONSOLE.formatter=COLOR-PATTERN
handler.CONSOLE.properties=autoFlush,target,enabled
handler.CONSOLE.autoFlush=true
handler.CONSOLE.target=SYSTEM_OUT
handler.CONSOLE.enabled=true

formatter.COLOR-PATTERN=org.jboss.logmanager.formatters.PatternFormatter
formatter.COLOR-PATTERN.properties=pattern
formatter.COLOR-PATTERN.pattern=%K{level}%d{HH\:mm\:ss,SSS} %-5p [%t] %c: %s%E%n