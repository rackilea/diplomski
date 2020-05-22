JSONObject jsonobject,jsonobject1;  
    try {
        HttpClient Client = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(Const.URL_JSON_OBJECT.trim());
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        Content = Client.execute(httpget, responseHandler);
        jsonobject = new JSONObject(Content);   
        //jsonobject1 = (JSONObject)jsonobject.get("results");
        JSONArray locationArray = jsonobject.getJSONArray("results").getJSONObject(0).getJSONArray("locations");
        String adminArea5 = locationArray.getJSONObject(0).getString("adminArea5");
        jsonobject = new JSONObject(obj);