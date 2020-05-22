SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
sourceBuilder.query(QueryBuilders.boolQuery()
                    .must(QueryBuilders
                        .rangeQuery("date_added")
                            .from(start.getTime())
                            .to(end.getTime()))
                    )
                   );

// add these two lines
TermsAggregationBuilder groupBy = AggregationBuilders.terms("byType").field("type.keyword");
sourceBuilder.aggregation(groupBy);