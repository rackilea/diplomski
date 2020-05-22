handlers =java.util.logging.FileHandler,java.util.logging.ConsoleHandler
.level = INFO

# File Logging
java.util.logging.FileHandler.pattern = %h/logfilename%u.log
java.util.logging.FileHandler.formatter = java.util.logging.SimpleFormatter
java.util.logging.FileHandler.level = INFO
java.util.logging.FileHandler.limit = 10485760
java.util.logging.FileHandler.count = 10

#java.util.logging.ConsoleHandler.formatter = org.springframework.boot.logging.java.SimpleFormatter
java.util.logging.ConsoleHandler.formatter = java.util.logging.SimpleFormatter
java.util.logging.ConsoleHandler.level = INFO

org.hibernate.validator.internal.util.Version.level = WARNING
org.apache.coyote.http11.Http11NioProtocol.level = WARNING
org.apache.tomcat.util.net.NioSelectorPool.level = WARNING
org.apache.catalina.startup.DigesterFactory.level = SEVERE
org.apache.catalina.util.LifecycleBase.level = SEVERE

#java.util.logging.SimpleFormatter.format=%4$s: %5$s [%1$tc]%n
java.util.logging.SimpleFormatter.format=%d{dd-MM-yyyy HH:mm:ss.SSS} %magenta([%thread]) %highlight(%-5level) %logger{36}.%M - %msg%n