<appender name="app" class="ch.qos.logback.core.rolling.RollingFileAppender">
<file>${catalina.home}/logs/appname/app.log</file>
<rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
  <fileNamePattern>${catalina.home}/logs/archive/appname/app.%d{yyyy-MM-dd}.old.log</fileNamePattern>
  <maxHistory>30</maxHistory>
</rollingPolicy>
<encoder>
  <pattern>[%X{key}]%date{"yyyy-MM-dd'T'HH:mm:ss,SSSXXX", UTC} %-5level %logger{35}.%M[%L]-[%t] - %msg %n</pattern>
</encoder>