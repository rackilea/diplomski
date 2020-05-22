final DatabaseReference newPost = mDatabase.push();
final String id = newPost.getKey();
Map<String, Object> values = new HashMap<>();
values.put("title", title_val);
values.put("id", id);
newPost.setValue(values);