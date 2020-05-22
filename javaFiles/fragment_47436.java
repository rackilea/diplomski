try {
        JSONArray ja = new JSONArray(buffer.toString());
        JSONArray innerJsonArray = ja.getJsonArray(0);
        JSONObject object = innerJsonArray.getJSONObject(0);
        String title = object.getString("title");                
     } 
     catch (JSONException e) {
        Log.e("JSON Parser", "Error parsing data " + e.toString());
     }