<?xml version="1.0"?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">

<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    <appender name="CONSOLE" class="org.apache.log4j.ConsoleAppender">
        <layout class="org.apache.log4j.EnhancedPatternLayout">
            <param name="ConversionPattern" value="%d{ABSOLUTE} %-5p [%t][%c{1}:%L] %m%n" />
        </layout>
    </appender>

    <appender name="eventFILE" class="org.apache.log4j.DailyRollingFileAppender">
       <param name="File" value="@tomcat.home@/logs/event.log" />
       <param name="DatePattern" value="'.'yyyy-MM-dd" />
       <layout class="org.apache.log4j.PatternLayout">
          <param name="ConversionPattern" value="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"/>
       </layout>
    </appender>

    <appender name="errorFILE" class="org.apache.log4j.DailyRollingFileAppender">
       <param name="File" value="@tomcat.home@/logs/error.log" />
       <param name="DatePattern" value="'.'yyyy-MM-dd" />
       <layout class="org.apache.log4j.PatternLayout">
          <param name="ConversionPattern" value="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"/>
       </layout>
    </appender>

    <logger name="event" additivity="false">
        <level value="INFO" />
        <appender-ref ref="eventFILE" />
    </logger>

    <logger name="error" additivity="false">
        <level value="INFO" />
        <appender-ref ref="errorFILE" />
    </logger>

    <root>
        <priority value="INFO" />
        <appender-ref ref="FILE" />
    </root>
</log4j:configuration>