private void flatten(Map<String, Object> map, Map<String, Object> output, String key) throws JSONException {
        String prefix = "";
        if (key != null) {
            prefix = key + ".";
        }
        for (Entry<String, Object> entry : map.entrySet()) {
            String currentKey = prefix + entry.getKey();
            if (entry.getValue() instanceof Map) {
                flatten((Map<String, Object>) entry.getValue(), output, prefix + entry.getKey());
            } else if (entry.getValue() instanceof List) {
                output.put(currentKey, entry.getValue());
            } else {
                output.put(currentKey, entry.getValue());
            }
        }
    }