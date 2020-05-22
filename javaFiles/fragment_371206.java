HashMap<String, String> parameters = new HashMap<String, String>();

    String query = "result=success&id=8a8d3c30-e184-11e1-9b23-0800200c9a66&name=wahooooooo";
    List<NameValuePair> params = URLEncodedUtils.parse(query, Charset.defaultCharset());
    for (NameValuePair nameValuePair : params) {
        parameters.put(nameValuePair.getName(), nameValuePair.getValue());
    }