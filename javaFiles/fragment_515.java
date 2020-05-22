AggregationOperation match = Aggregation.match(Criteria.where("key.carrier").is(carrierId));
AggregationOperation group = Aggregation.group("status").count().as("count");
AggregationOperation project = Aggregation.project("count").andExclude("_id").andInclude(Fields.from(Fields.field("status", "_id")));


Aggregation agg = Aggregation.newAggregation(match,group,project);

List<YourPojo> results = mongoTemplate.aggregate(agg, colname, YourPojo.class).getMappedResult();