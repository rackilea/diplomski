final JSONObject jsonObject = new JSONObject(str);
final JSONArray posts = jsonObject.getJSONArray("posts");
final Collection<String> values = new ArrayList<>(posts.length());

for (int i = 0; i < posts.length(); i++) {
    final JSONObject post = posts.getJSONObject(i);
    values.add(post.getString("value"));
}

// values = [x, 0, y]