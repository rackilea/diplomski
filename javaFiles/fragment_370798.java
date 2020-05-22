//
    String url = 'url_to_you_server_api.dev/postservice'

    HttpClient client = new DefaultHttpClient();

    HttpPost request = new HttpPost(url);

    JSONObject params = new JSONObject();

    params.put("id","id");
    params.put("hi","hi");

    StringEntity jsonEntity = new StringEntity( params.toString() );

    HttpPost request = new HttpPost(url);

    request.addHeader("Content-Type","application/json");

    request.setEntity(jsonEntity);

    response = client.execute(request);