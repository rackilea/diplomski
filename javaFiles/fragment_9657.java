private BytesRestResponse search2restResponse(SearchResponse sr) {
    SearchHit[] searchHits = sr.getHits().getHits();
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    for (int i = 0; i < searchHits.length; i++) {
        if (i > 0) {
            builder.append(",");
        }
        builder.append(searchHits[i].getSourceAsString());
    }
    builder.append("]");
    String res_json = builder.toString();
    return new BytesRestResponse(RestStatus.OK, res_json);
}