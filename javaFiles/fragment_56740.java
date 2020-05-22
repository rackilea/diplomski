<configuration scan="true">

  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <layout class="ch.qos.logback.classic.PatternLayout">
      <Pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</Pattern>
    </layout>
  </appender>

  <!-- ### log just the SQL ### -->
  <logger name="org.hibernate.SQL" level="DEBUG"/>

  <!-- ### log JDBC bind parameters ### -->
  <logger name="org.hibernate.type" level="TRACE"/>

  <logger name="org.hibernate.tool.hbm2ddl" level="DEBUG"/>

  <root level="ERROR">
    <appender-ref ref="STDOUT"/>
  </root>
</configuration>