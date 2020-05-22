public JSONObject get(JSONObject payload, String URL) throws Exception {

    JSONArray jsonArray = new JSONArray();
    CloseableHttpClient client = HttpClientBuilder.create().build();

    HttpGetWithEntity myGet = new HttpGetWithEntity(WeeblyAPIHost+URL);
    myGet.setEntity( new StringEntity("[]") );
    myGet.setHeader("Content-Type", "application/json");
    myGet.setHeader("X-Public-Key", APIKey);
    HttpResponse response = client.execute(myGet);

    JSONParser parser = new JSONParser();
    Object obj = parser.parse( EntityUtils.toString(response.getEntity(), "UTF-8") ) ;
    JSONObject jsonResponse = (JSONObject) obj;

    return jsonResponse;

}