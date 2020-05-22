ArrayList<String> id = new ArrayList<>();
for (DataSnapshot ds : dataSnapshot.getChildren()) {
    id.add(ds.getKey().toString());
    String title = ds.child("title").getValue(String.class);
    String content = ds.child("content").getValue(String.class);
    String timestamp = ds.child("timestamp").getValue(String.class);
    list.add(title + "\n" + content + "\n" + timestamp);
    Log.d("TAG", title);
}