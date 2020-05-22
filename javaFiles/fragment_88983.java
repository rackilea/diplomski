public SearchRequest source(Map source) {
    try {
        XContentBuilder builder = XContentFactory.contentBuilder(Requests.CONTENT_TYPE);
        builder.map(source);
        return source(builder);
    } catch (IOException e) {
        throw new ElasticsearchGenerationException("Failed to generate [" + source + "]", e);
    }
}