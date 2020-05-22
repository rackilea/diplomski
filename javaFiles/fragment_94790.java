JSONArray a1 = new JSONArray(json);
for (int i = 0; i < a1.length(); i++) {
    JSONArray a2 = a1.getJSONArray(i);
    for (int j = 0; j < a2.length(); j++) {
    String s1 = a2.getString(j);
        // ...
    }
}