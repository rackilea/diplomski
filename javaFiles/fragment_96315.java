<RollingFile name="General" fileName="log/logs/giornale.log" filePattern="log/logs/log-%d{yyyyMMdd}.log">

  <PatternLayout>
    <Pattern>%d{HH:mm:ss,SSS} [%t] %-5level %logger{-1} - %msg%n</Pattern>
  </PatternLayout>

  <Policies>
    <TimeBasedTriggeringPolicy />
  </Policies>

  <DefaultRolloverStrategy max="<specify maximum archive count>"/>

</RollingFile>