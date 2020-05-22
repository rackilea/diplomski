StringRequestEntity requestEntity = new StringRequestEntity(
    JSON_STRING,
    "application/json",
    "UTF-8");

PostMethod postMethod = new PostMethod("http://example.com/action");
postMethod.setRequestEntity(requestEntity);

int statusCode = httpClient.executeMethod(postMethod);