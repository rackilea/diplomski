@Override
public void onResponse(NetworkResponse response) {
    try {
        final String jsonString = new String(response.data,
                HttpHeaderParser.parseCharset(response.headers));
        // Check if it is JSONObject or JSONArray
        Object json = new JSONTokener(jsonString).nextValue();          
        if (json instanceof JSONObject) {
            //do something...
        } else if (json instanceof JSONArray) {
            //do something...
        } else {
            //do something...
        }
        ...
    } catch (UnsupportedEncodingException | JSONException e) {
        e.printStackTrace();
    }
}