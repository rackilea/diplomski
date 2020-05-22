public static String getStringUnicodeAsNull1(JSONObject jsonObject,
        String key) {
    try {
        if(jsonObject.isNull(key))
            return null;
        else
        return StringEscapeUtils.unescapeJava(jsonObject.getString(key));
    } catch (JSONException je) {
        return null;
    }
}