DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference locationRef = rootRef.child("location");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            MarkerLocation markerLocation = ds.getValue(MarkerLocation.class);
            LatLng latLng = new LatLng(markerLocation.getLatitude(), markerLocation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng));
            Log.d(TAG, markerLocation.getLatitude() + ", " +  markerLocation.getLongitude());
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
locationRef.addListenerForSingleValueEvent(valueEventListener);