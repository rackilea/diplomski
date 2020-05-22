<aggregate strategyRef="myAggregationStrategy" completionSize="3">
    <correlationExpression> 
        <simple>${header.id} == 1</simple> 
    </correlationExpression>
    <to uri="bean:processorBean?method=process" /> 
    <to uri="bean:finalizerBean?method=shutdown" /> 
</aggregate>