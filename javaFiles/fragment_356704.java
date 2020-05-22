private String httpBuildQuery(Map<String, String> data)
        throws UnsupportedEncodingException {
    QueryStringBuilder builder = new QueryStringBuilder();
    for (Entry<String, String> pair : data.entrySet()) {
        builder.addQueryParameter(pair.getKey(), pair.getValue());
    }
    return builder.encode("UTF-8");
}