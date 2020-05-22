String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("Users").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(Color.RED);
        polylineOptions.width(3);
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            double latitude = ds.child("latitude").getValue(Double.class);
            double longitude = ds.child("longitude").getValue(Double.class);
            polylineOptions.add(new LatLng(latitude, longitude));
        }
        Polyline polyline = mMap.addPolyline(polylineOptions);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
uidRef.addListenerForSingleValueEvent(valueEventListener);