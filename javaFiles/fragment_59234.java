reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        Post post = dataSnapshot.getValue(Post.class);
        if (post != null) {
            double latitude = post.getLocation().getLatitude();
            double longitude = post.getLocation().getLongitude();

            LatLng location = new LatLng(latitude, longitude);
            map.addMarker(new MarkerOptions().position(location).title("Event location"));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10));
        } else {
            Toast.makeText(MapsActivityUser.this, "Event doesn't have location on Map", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});