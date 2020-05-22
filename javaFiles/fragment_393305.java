JSONObject txn = jObject.getJSONObject("txn");
if (txn != null) {
    Map<String, Object> map = new HashMap<String, Object>();
    Iterator iter = txn.keys();
    while (iter.hasNext()) {
        String key = (String) iter.next();
        JSONObject valueObj = txn.getJSONObject(key);
        String value = valueObj.getString("=");
        String[] keyParams = key.split("[\\(\\)]");

        if (keyParams.length > 1) { // it means it contains index

            // checking for old map
            Map<String, String> innerMap = (Map<String, String>) map.get(keyParams[0]);

            if (innerMap == null) {
                innerMap = new HashMap<String, String>();
            }
            innerMap.put(keyParams[1], value);
            map.put(keyParams[0], innerMap);
        } else {
            map.put(key, value);
        }

    }
}