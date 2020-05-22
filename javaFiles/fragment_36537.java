SearchRequest searchRequest = new SearchRequest("index_name"); 
SearchSourceBuilder searchBuilder = new SearchSourceBuilder(); 
searchBuilder.query(QueryBuilders.matchAllQuery()); 
searchBuilder.size(0);
searchRequest.source(searchBuilder); 

SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
SearchHits hits = searchResponse.getHits();
long totalHits = hits.getTotalHits();
if(totalHits == 0) {
    // proceed
}