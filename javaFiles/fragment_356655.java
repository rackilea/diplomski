try {
     JSONObject jobj = new JSONObject(responseContent);
    JSONArray users = jobj.getJSONArray("users");

    for(i=0;i<users.length();i++){
    JSONObject jobj1 = users.getJSONObject(i);
    String user=jobj1.getString("user");
    String user_id=jobj1.getString("id_user");
    }
}
 catch (JSONException e1) {
         e1.printStackTrace();
}