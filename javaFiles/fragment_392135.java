public Object stringify(Object x) {
    if (x instanceof JSONObject) {
        JSONObject obj = (JSONObject) x;
        for (String key : obj.keySet()) {
            obj.put(key, stringify(obj.get(key)));
        }
    } else if (x instanceof JSONArray) {
        JSONArray arr = (JSONArray) x;
        for (int i = 0; i < arr.length(); i++) {
            arr.put(i, stringify(arr.get(i)));
        }
    } else {
        x = String.valueOf(x);
    }
    return x;
}