FilteredQueryBuilder builder = QueryBuilders.filteredQuery(QueryBuilders.queryString("Spectra"), FilterBuilders.termFilter("Data.Date", "01.06.2014"));


        SearchResponse response = elasticClient.prepareSearch("mone")
                .setTypes("mone")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(builder)
                .execute()
                .actionGet();

        System.out.println(response);