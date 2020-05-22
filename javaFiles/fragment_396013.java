public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
    assert map != null;
    for (Map.Entry<String, Object> entry : map.entrySet()) {
        Log.i("The key", entry.getKey());
        Map<String,String> values = (Map<String,String>) entry.getValue();
        Log.i("station_name", map.get("station_name"));
    }
}