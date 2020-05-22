try{
   JSONObject jsonObject = new JSONObject(response);
   JSONArray addressObject = jsonObject.getJSONObject("address");
   state = addressObject.getString("state");
   country= addressObject.getString("country");
}