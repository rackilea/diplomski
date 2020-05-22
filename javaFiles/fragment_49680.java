FilterBuilder filterBuilder = FilterBuilders.rangeFilter("datePublished")
        .gte("2016-01-01T12:30:00+01:00")
        .includeLower(false).includeUpper(false);

    MoreLikeThisQueryBuilder mltQueryBuilder = QueryBuilders.moreLikeThisQuery("title", "description", "body", "organisations","locations")
        .minTermFreq(2)
        .maxQueryTerms(25)
        .ids("http://xxx/doc/doc");

    SearchRequestBuilder searchRequestBuilder = client.prepareSearch("index");

    searchRequestBuilder.setTypes("type");
    searchRequestBuilder.addFields("title","description","datePublished");
    searchRequestBuilder.setQuery(mltQueryBuilder).setPostFilter(filterBuilder);

    searchRequestBuilder.execute().actionGet()