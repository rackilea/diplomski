<appender name="Daily" class="org.apache.log4j.DailyRollingFileAppender">
 <param name="file" value="${catalina.home}/logs/test.log" />
 <param name="DatePattern" value="'.'yyyy-MM-dd" />
 <param name="MaxBackupIndex" value="10" />
 <layout class="org.apache.log4j.PatternLayout">
  <param name="ConversionPattern" value="[%t] %d{HH:mm:ss,SSS} %-5p %l - %m%n" />
 </layout>
</appender>