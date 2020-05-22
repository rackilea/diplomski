StringEntity requestEntity = new StringEntity(
    JSON_STRING,
    ContentType.APPLICATION_JSON);

HttpPost postMethod = new HttpPost("http://example.com/action");
postMethod.setEntity(requestEntity);

HttpResponse rawResponse = httpclient.execute(postMethod);