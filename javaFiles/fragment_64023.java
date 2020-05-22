MatchOperation matchOperation = match(Criteria.where("imei").is(imei) 
     .and("timestamp").gte(from.getTime()).lte(to.getTime()));

GroupOperation groupOperation = group("imei").sum("point_distance").as("distance");
ProjectionOperation projectionOperation = project().andExpression("imei").as("imei")
    .andExpression("distance").as("distance");

Aggregation aggregation = newAggregation(matchOperation, groupOperation, projectionOperation);
AggregationResults<DistanceInfo> results = mongoTemplate.aggregate(aggregation, "location", DistanceInfo.class);

return  results.getMappedResults();