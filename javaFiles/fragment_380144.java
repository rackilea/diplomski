// Get our response as a String.
    String jsonString = EntityUtils.toString(response.getEntity());
   JSONObject m_jobj;
try {
    m_jobj = new JSONObject(jsonString);
    JSONArray m_ja = m_jobj.getJSONArray("cityData");
    for (int i = 0; i < m_ja.length(); i++) 
     {
                 JSONObject m_obj = m_ja.getJSONObject(i);
                  String city=m_obj.getString("cityID");
                  String cityName=m_obj.getString("cityName");
                   //And so on get all the values.
               }