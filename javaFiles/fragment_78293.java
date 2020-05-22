JSONArray shots = response.getJSONArray("shots");
String titles[] = new String[shots.length()];
for (int i=0; i < shots.length(); i++) {
    JSONObject post = shots.getJSONObject(i);
    String title = post.getString("title");

    titles[i] = title;
}