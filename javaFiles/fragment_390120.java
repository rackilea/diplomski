private JSONObject parseObjectToJson(ParseObject parseObject) throws ParseException, JSONException {
    JSONObject jsonObject = new JSONObject();
    parseObject.fetchIfNeeded();
    Set<String> keys = parseObject.keySet();
    for (String key : keys) {
        Object objectValue = parseObject.get(key);
        if (objectValue instanceof ParseObject) {
            jsonObject.put(key, parseObjectToJson(parseObject.getParseObject(key)));
            // keep in mind about "pointer" to it self, will gain stackoverlow
        } else if (objectValue instanceof ParseRelation) {
            // handle relation
        } else {
            jsonObject.put(key, objectValue.toString());
        }
    }
    return jsonObject;
}