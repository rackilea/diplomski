while (keys.hasNext() && ld == null) {
    ...
    else if (json.get(key) instanceof JSONObject) {
        ld = getTimeStamp((JSONObject) json.get(key));
    }
    // handle current value being JSON array
    else if (json.get(key) instanceof JSONArray) {
        JSONArray jarray = (JSONArray) json.get(key);
        for (int i = 0; i < jarray.length(); i++) {
            if (jarray.get(i) instanceof JSONObject) {
                ld = getTimeStamp((JSONObject) jarray.get(i));
                if (ld != null) 
                    break;
            }
        }
    }
}