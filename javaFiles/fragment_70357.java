AggregationBuilder builder = AggregationBuilders.global("agg")
                .subAggregation(AggregationBuilders.terms("genders")
                        .field("gender"));
SearchRequestBuilder queryBuilder= client2.prepareSearch(INDEX_NAME)
        .setTypes(TYPE_NAME).setSize(0).addAggregation(builder); //client2 is a client initialized with the transport client
Search search = new Search.Builder(queryBuilder.toString()).addIndex("_all").addType("*").build();
SearchResult res = client.execute(search);
//          System.out.println(res.toString());
System.out.println(res.getJsonString());