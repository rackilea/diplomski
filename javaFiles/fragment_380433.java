private void showJSON(String json){
    try{
    JSONArray jsonArray = new JSONArray(json);
     for (int i = 0; i < jsonArray.length(); i++) {

       String id[i] = jsonArray.getJSONObject(i).getString("id");
       String email[i] = jsonArray.getJSONObject(i).getString("email");
     }
     }
    catch (JSONException e) {
                // Log.d("JSONException", e.toString());
            }
     }