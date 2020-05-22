<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>${user.home}/logback.log</file>
    <encoder>
        <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger - %msg%n</pattern>
    </encoder>
</appender>