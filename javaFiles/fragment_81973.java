filterMax = AggregationBuilders.filter(....);
aggMax = AggregationBuilders.max("agg_max")..;

NestedAggregationBuilder maxAggregation = 
AggregationBuilders.nested("nested_max", questionResponses)
                   .subAggregation(aggFilterMax.subAggregation(aggMax));