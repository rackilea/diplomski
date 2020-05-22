<appender name="FILE" class="org.apache.log4j.RollingFileAppender">
         <param name="File" value="${catalina.base}/logs/<logFile>.log"/>
         <param name="MaxFileSize" value="1MB"/>
         <param name="MaxBackupIndex" value="100"/>
         <layout class="org.apache.log4j.PatternLayout">
              <param name="ConversionPattern"
                         value="[%d{dd/MM/yy hh:mm:ss:sss z}] %5p %c{2}: %m%n" />
         </layout>
</appender>