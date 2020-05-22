// sr is here your SearchResponse object
Terms agg = sr.getAggregations().get("agg");

// For each entry
for (Terms.Bucket entry : agg.getBuckets()) {
    String key = entry.getKey();                    // bucket key
    long docCount = entry.getDocCount();            // Doc count
    logger.info("key [{}], doc_count [{}]", key, docCount);

    // We ask for top_hits for each bucket
    TopHits topHits = entry.getAggregations().get("top");
    for (SearchHit hit : topHits.getHits().getHits()) {
        logger.info(" -> id [{}], _source [{}]", hit.getId(), hit.getSourceAsString());
    }
}