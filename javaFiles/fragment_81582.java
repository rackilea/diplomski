String myEscapedUrl = "https://zw5yb.app.goo.gl/?link=" + URLEncoder.encode(assetUrl, "UTF-8");
FirebaseDynamicLinkRequest dynamicLinkRequest = new FirebaseDynamicLinkRequest(myEscapedUrl);
httpPost.setEntity(new StringEntity(mapper.writeValueAsString(dynamicLinkRequest)));
// inform the server about the type of the content   
httpPost.setHeader("Accept", "application/json");
httpPost.setHeader("Content-type", "application/json");
responseBody = httpClient.execute(httpPost, responseHandler);