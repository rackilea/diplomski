JSONObject jsonObj = new JSONObject(Response);
 JSONArray JsonArray = jsonObj.getJSONArray("api_data");

 for (int i = 0; i < JsonArray.length(); i++) {
 JSONObject jsonObject = JsonArray.getJSONObject(i);

   String id=jsonObject.getString("ID");
   String projectname=jsonObject.getString("project_name");
   String content=jsonObject.getString("project_content");

  }