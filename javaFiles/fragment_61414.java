<configuration>
    <appender name="FILE" class="ch.qos.logback.core.FileAppender">
        <file>${application.home}/logs/application.log</file>
        <encoder>
            <pattern>%date - [%level] - from %logger in %thread %n%message%n%xException%n</pattern>
        </encoder>
    </appender>

    <appender name="ASYNC" class="ch.qos.logback.classic.AsyncAppender">
        <appender-ref ref="FILE" />
    </appender>

    <root level="WARN">
        <appender-ref ref="ASYNC" />
    </root>
</configuration>