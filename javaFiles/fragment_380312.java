JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        Settings s = ImmutableSettings.settingsBuilder()
                .put("cluster.name", SEARCH_CLUSTER_NAME).build();
        SEARCH_CLIENT = new TransportClient(s)
                .addTransportAddress(new InetSocketTransportAddress(
                        SEARCH_HOST, Integer.parseInt(SEARCH_PORT)));

        SearchResponse searchResponse = SEARCH_CLIENT
                .prepareSearch(SEARCH_INDEX_NAME)
                .setScroll(new TimeValue(600000))
                .setTypes(SEARCH_TYPE_NAME)
                .setSearchType(SearchType.SCAN)
                .setQuery(QueryBuilders.matchAllQuery())
                .execute()
                .actionGet();

        while (true) {
            searchResponse = SEARCH_CLIENT
                    .prepareSearchScroll(searchResponse.getScrollId())
                    .setScroll(new TimeValue(600000)).execute().actionGet();
            for (SearchHit hit : searchResponse.getHits()) {

                jsonObject = (JSONObject) parser.parse(hit
                        .getSourceAsString());

            }
            // Break condition: No hits are returned
            if (searchResponse.getHits().getHits().length == 0) {
                break;
            }
        }