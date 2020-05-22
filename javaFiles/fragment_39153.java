DefaultHttpClient httpClient = new DefaultHttpClient();
    HttpGet getRequest = new HttpGet(
        "http://localhost:8080/RESTfulExample/json/product/get");
    getRequest.addHeader("accept", "application/json");

    HttpResponse response = httpClient.execute(getRequest);

    if (response.getStatusLine().getStatusCode() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
           + response.getStatusLine().getStatusCode());
    }

    BufferedReader br = new BufferedReader(
                     new   InputStreamReader((response.getEntity().getContent())));