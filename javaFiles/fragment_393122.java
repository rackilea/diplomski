ArrayList<String> result = new ArrayList<String>();
try {
    JSONObject jObject = new JSONObject(json.trim());
    Iterator<?> keys = jObject.keys();
    while (keys.hasNext()) {
        String s = jObject.getString((String) keys.next());
        s = s.substring(0, s.indexOf(",", s.indexOf(",") + 1));
        result.add(s);
    }
} catch (JSONException e) {
    e.printStackTrace();
}