JSONObject json = new JSONObject();
Set<String> keys = bundle.keySet();
for (String key : keys) {
    try {
        // json.put(key, bundle.get(key)); see edit below
        json.put(key, JSONObject.wrap(bundle.get(key)));
    } catch(JSONException e) {
        //Handle exception here
    }
}