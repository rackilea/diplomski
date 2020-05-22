public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
    for (DataSnapshot stationSnapshot: dataSnapshot.getChildren()) {
        Log.i("The key", stationSnapshot.getKey());
        Log.i("station_name", stationSnapshot.child("station_name").getValue(String.class));
    }
}