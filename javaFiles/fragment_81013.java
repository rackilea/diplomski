Map<String, Integer> map = new HashMap<>();

for (int i = 0; i < jsonArray.length; i++) {
    JSONObject list = jsonArray.getJSONObject(i);
    String key = list.getString("date");
    if (!map.containsKey(key) {
        map.put(key, list.getInt("value");
    } else {
        int val = map.get(key) + list.getInt("value");
        map.put(key, val);
    }
}