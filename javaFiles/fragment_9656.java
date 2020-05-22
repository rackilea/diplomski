@Override
protected void handleRequest(RestRequest request, RestChannel channel, final Client client) throws Exception {
    // Get the address parameter
    String address = request.param("address");

    // ... Code that parses address and extracts house number ...
    int house = ...

    // Now send both parameters as query to search engine
    SearchResponse sr = client
        .prepareSearch("myindex")
        .setTypes("mytype")
        // Query all shards, DFS==calculate global words' frequencies
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        // Address string without (cutted) house number   
        .setQuery(QueryBuilders.matchQuery("address", address))
        // And extracted house number as second filtering parameter
        .setPostFilter(QueryBuilders.termQuery("houses", house))
        // Starting position of the first returning hit
        .setFrom(0)
        // Max number of hits
        .setSize(10)
        // Explain hit score 
        .setExplain(true)
        .get();

        // Convert the search response to rest response and send it
        BytesRestResponse sr_rest = search2restResponse(sr);
        channel.sendResponse(sr_rest);
    }
}