try{
    JSONArray jsonArray = new JSONArray(result);
    // looping through All jsonObject
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        String id = jsonObject.getString("id");
        String title = jsonObject.getString("title");
        String description = jsonObject.getString("description");
        String img_url = jsonObject.getString("img_url");
    }
} catch (JSONException e) {
    e.printStackTrace();
}