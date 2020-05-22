Object object = jsonObject.get("key");
    if (object instanceof JSONObject) {
    // It is json object
    } else if (object instanceof JSONArray) {
    // It is Json Array
    } else {
    // It is a String
    }