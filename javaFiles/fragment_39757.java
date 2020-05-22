// create the sum aggregations
SumBuilder sumMarks = AggregationBuilders.sum("sum_marks").field("marks");
SumBuilder sumGrades = AggregationBuilders.sum("sum_grade").field("grade");

// create the year aggregation + add the sum sub-aggregations
TermsBuilder yearAgg = AggregationBuilders.terms("by_year").field("year")
    .subAggregation(sumMarks)
    .subAggregation(sumGrades);

// create the bool filter for the condition above
String[] names = {"stokes","roshan"};
BoolQueryBuilder aggFilter = QueryBuilders.boolQuery()
    .must(QueryBuilders.termsQuery("Name", names))
    .must(QueryBuilders.rangeQuery("grade").lte(9.0))

// create the filter aggregation and add the year sub-aggregation
FilterAggregationBuilder aggregation = AggregationBuilders.filter("agg")
    .filter(aggFilter)
    .subAggregation(yearAgg);

// create the request and execute it
SearchResponse response = client.prepareSearch(index)
    .setTypes(datasquareID)
    .addAggregation(aggregation)
    .execute().actionGet();
System.out.println(response.toString());