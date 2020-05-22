try {
    JSONArray resultsArray = rootObject.getJSONArray("results");
    for (int i = 0; i < resultsArray.length(); i++) {
        JSONObject teamObject = resultsArray.getJSONObject(i);
        String fullText = teamObject.getString("fulltext");
    }
} catch (JSONException e) {
    e.printStackTrace();
}