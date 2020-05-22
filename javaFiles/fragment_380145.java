public static JSONArray getJSONArrayFromUrl(String url) throws Exception {
    try {


           HttpClient client = getHttpClient();

           HttpGet request = new HttpGet();

           request.setURI(new URI(url));

           HttpResponse response = client.execute(request);

        try {
            // Get our response as a String.
            String jsonString = EntityUtils.toString(response.getEntity());
       JSONObject m_jobj;
    try {
    m_jobj = new JSONObject(jsonString);
    JSONArray m_ja = m_jobj.getJSONArray("cityData");
    /*for (int i = 0; i < m_ja.length(); i++) 
             {
             JSONObject m_obj = m_ja.getJSONObject(i);
                  String city=m_obj.getString("cityID");
                  String cityName=m_obj.getString("cityName");
                   //And so on get all the values.
               }*/


            // Parse the JSON String into a JSONArray object.
            return m_ja;

        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;

    }