JSONObject layoutJson;
JSONArray  layoutData = layoutJson.getJSONArray();
for (int i = 0; i < layoutData.length(); i++) {
    JSONObject firstArray = (JSONObject)layoutData.getJSONObject(i);
    // Do whatever you want with first array
    // you can loop through the first array again
}