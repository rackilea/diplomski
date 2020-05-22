HttpClient httpClient = HttpClientBuilder.create().build();
    String url = "https://invoice.zoho.com/api/v3/contacts?authtoken=AUTHTOKEN&organization_id=ORGID";
    HttpPost request = new HttpPost(url);

    JSONObject json = new JSONObject();
    json.put("contact_name", "Test");
    //You can add other JSONString params here.

    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("JSONString", json.toString()));
    //You can add other params like JSONString here.

    request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
    request.addHeader("Accept", "application/json");
    HttpResponse response = httpClient.execute(request);

    ResponseHandler<String> handler = new BasicResponseHandler();

    System.out.println(response.getStatusLine().getStatusCode());
    String body = handler.handleResponse(response);

    System.out.println(body);