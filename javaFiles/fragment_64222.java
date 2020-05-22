Map<String, String> colMapObj = new HashMap<>();
    colMapObj.put("testKey", "testdata");

    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(url);

    JSONObject body = new JSONObject(colMapObj);
    StringEntity entity = new StringEntity(body.toString());
    httpPost.setEntity(entity);
    httpPost.setHeader("Accept", "application/json");
    httpPost.setHeader("Content-type", "application/json");

    CloseableHttpResponse response = client.execute(httpPost);
    System.out.println(response.getEntity().toString());
    client.close();