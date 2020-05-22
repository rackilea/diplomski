SearchHits enTextSearchHits = testClient.prepareSearch(test_index)
    .setTypes(ARTICLE_TYPE)
    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
    .setQuery(nestedQuery("texts", queryStringQuery("texts.value.en:summer")))
    .execute().get().getHits();

SearchHits enTextSearchMatchHits = client.prepareSearch(test_index)
    .setTypes(ARTICLE_TYPE)
    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
    .setQuery(nestedQuery("texts", matchQuery("texts.value.en", "summer")))
    .execute().get().getHits();