try { 
JSONArray result = new JSONArray(response);
for(int i=0; i<result.length(); i++){
   JSONObject obj = result.getJSONObject(i);
  // Proceed with your logic with each object accordingly.
}
} catch (JSONException e) { e.printStackTrace(); 
}