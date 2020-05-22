StringEntity postingString = new StringEntity(<<myStringObjectAsJson>>);

String url = "/HTTPJavaAdapter/endPoint";
HttpPost httpPost = new HttpPost(url);
httpPost.setEntity(postingString);
httpPost.setHeader("Content-type", "application/json");

HttpUriRequest req = httpPost;
adaptersAPI.executeAdapterRequest(req);