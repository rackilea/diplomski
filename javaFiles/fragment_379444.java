for (int i = 0; i < json.length(); i++) {
    JSONObject container = json.getJSONObject(i);
    // We don't know the property name, but there's only one, apparently...
    String key = container.keys().next();
    JSONArray subarray  = container.getJSONArray(key);
    for (int j = 0; j < subarray.length(); j++) {
        listdata.add(subarray.getJSONObject(j).getString("path"));
    }
}