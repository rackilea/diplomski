public String getEncodedQueryString(Map<String, String> parameters) {
    StringBuilder queryStringBuilder = new StringBuilder("?");
    parameters.entrySet().stream().forEach(e -> {
        queryStringBuilder.append(e.getKey());
        queryStringBuilder.append("=");
        try {
            queryStringBuilder.append(
                URLEncoder.encode(e.getValue() == null ? "" : e.getValue().toString(), StandardCharsets.UTF_8.name())
            );
        }
        catch (UnsupportedEncodingException e1) {
            queryStringBuilder.append("");
        }
        queryStringBuilder.append("&");
    });
    return queryStringBuilder.toString().substring(0, queryStringBuilder.toString().length()-1);
}