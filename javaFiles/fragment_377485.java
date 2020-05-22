Iterator<String> iterator = json.keys();
while (iterator .hasNext()) {
    String key = iterator .next();
    try {
        Object value = json.get(key);
    } catch (JSONException e) {

    }
}