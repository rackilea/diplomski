//Scroll until no hits are returned
while (true) {
    scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(600000)).execute().actionGet();
    //Break condition: No hits are returned
    if (scrollResp.getHits().getHits().length == 0) {
        logger.info("Closing the bulk processor");
        bulkProcessor.close();
        break; 
    }
    // Get results from a scan search and add it to bulk ingest
    for (SearchHit hit: scrollResp.getHits()) {
        IndexRequest request = new IndexRequest("new_index", hit.type(), hit.id());
        Map source = ((Map) ((Map) hit.getSource()));
        request.source(source);
        bulkProcessor.add(request);
   }
}