final int fetchAmount = 100; // number of items to return
final FilterBuilder filterBuilder = FilterBuilders.termFilter(fieldname, word);
final QueryBuilder combinedQuery = QueryBuilders.termQuery(fieldname, word);
final QueryBuilder queryBuilder = QueryBuilders.filteredQuery(combinedQuery, filterBuilder);
final SearchResponse builder = CLIENT.prepareSearch(index_name).setQuery(queryBuilder).setExplain(true)
        .setTypes(type_name).setSize(fetchAmount).setSearchType(SearchType.QUERY_THEN_FETCH).execute().actionGet();