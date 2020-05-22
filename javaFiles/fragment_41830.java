<filter class="ch.qos.logback.core.filter.EvaluatorFilter">
  <evaluator name="loggingTaskEval">
    <expression>
      message.contains("following ID will be dropped") &amp;&amp;
      (timeStamp - event.getStartTime()) >= 20000
    </expression>
  </evaluator>
  <OnMatch>DENY</OnMatch>
</filter>