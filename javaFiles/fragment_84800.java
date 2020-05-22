DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference studiosRef = rootRef.child("Studios");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            FirebaseMarker marker = dataSnapshot.getValue(FirebaseMarker.class);
            String StudioName = marker.getStudioName();
            String StudioAdress = marker.getStudioAddress();
            String StudioDescription = marker.getStudioDescription();
            double latitude = marker.getLatitude();
            double longitude = marker.getLongitude();
            LatLng location = new LatLng(latitude, longitude);

            map.addMarker(new MarkerOptions()
                    .position(location)
                    .title(StudioName)
                    .snippet(StudioAdress)
                    .snippet(StudioDescription))
                    .showInfoWindow();
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
studiosRef.addListenerForSingleValueEvent(valueEventListener);