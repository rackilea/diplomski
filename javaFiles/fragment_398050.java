SearchResponse response = client.prepareSearch("index")
      .setTypes("type")
      .setQuery(QueryBuilders.matchAllQuery())
      .addAggregation(AggregationBuilders.terms("TermsAggr")
           .field("aggField").size(100))
      .execute().actionGet();