UpdateByQueryRequest request = new UpdateByQueryRequest(INDEX_NAME);
    request.setConflicts("proceed");
    request.setQuery(QueryBuilders.boolQuery().filter(QueryBuilders.scriptQuery(new Script("doc['collibra_match_for.keyword'].values.length > 0"))));
    request.setScript(new Script(ScriptType.INLINE, "painless","ctx._source.collibra_match_for = []",Collections.emptyMap()));
    request.setRefresh(true);
    try {
        BulkByScrollResponse bulkResponse = esClient.updateByQuery(request, RequestOptions.DEFAULT);
        long totalDocs = bulkResponse.getTotal();
    } catch (IOException e) {
        e.printStackTrace();
    }