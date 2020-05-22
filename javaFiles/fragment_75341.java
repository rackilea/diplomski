import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

Aggregation agg = newAggregation(
    sort(DESC, "value"),
    group().first("value").as("largestValue")
           .first("dateTime").as("date")     
);

AggregationResults<TestMData> results = mongoTemplate.aggregate(agg, "test", TestMData.class);
List<TestMData> testData = results.getMappedResults();