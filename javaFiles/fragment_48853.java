logger.level=INFO

logger.handlers=FILE,CONSOLE

handler.CONSOLE=org.jboss.logmanager.handlers.ConsoleHandler
handler.CONSOLE.properties=autoFlush
handler.CONSOLE.level=INFO
handler.CONSOLE.autoFlush=true
handler.CONSOLE.formatter=PATTERN

handler.FILE=org.jboss.logmanager.handlers.FileHandler
handler.FILE.level=DEBUG
handler.FILE.properties=autoFlush,fileName
handler.FILE.autoFlush=true
handler.FILE.fileName=bridge.log
handler.FILE.formatter=PATTERN

formatter.PATTERN=org.jboss.logmanager.formatters.PatternFormatter
formatter.PATTERN.properties=pattern
formatter.PATTERN.pattern=%d{yyyy-MM-dd HH:mm:ss,SSS} %-5p [%c] (%t) %s%E%n