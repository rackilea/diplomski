import static org.elasticsearch.index.query.QueryBuilders.wildcardQuery;

BulkIndexByScrollResponse r = ubqrb.source("twitter")
    .script(script)
    .filter(wilcardQuery("url", "http://www.sea.com/bundle/*"))
    .get();