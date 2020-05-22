<configuration>

  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
      <pattern>Stdout: %d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
    </encoder>
  </appender>

  <appender name="ALTOUT" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
      <pattern>Altout: %d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
    </encoder>
  </appender>

  <logger name="Flop"  level="error" additivity="true">
    <appender-ref ref="STDOUT" />
  </logger>

  <root level="warn">
    <appender-ref ref="ALTOUT" />
  </root>
</configuration>