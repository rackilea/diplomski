<RollingFile name="analyticsFileAppender" fileName="/tmp/ops_bc_log"
             filePattern="'-'yyyyMMdd">
  <PatternLayout pattern="%d{yyyy/MM/dd HH:mm:ss} %m%n"/>
  <Policies>
    <TimeBasedTriggeringPolicy />
  </Policies>
</RollingFile>