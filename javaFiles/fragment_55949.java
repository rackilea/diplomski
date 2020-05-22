HttpClient httpClient = HttpClientBuilder.create().build();
    HttpGet httpGet = new HttpGet(uri);

    // Set the basic authentication
    String encoding = Base64Encoder.encode("user:pass");
    httpGet.setHeader("Authorization", "Basic" + encoding);

    HttpResponse httpResponse = httpClient.execute(httpGet);
    HttpEntity entity = httpResponse.getEntity();