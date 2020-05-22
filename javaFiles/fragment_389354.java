public void readData(MyCallback myCallback) {
    refDatabase.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            newlocation = new LatLng(dataSnapshot.child("latitude").getValue(Double.class),dataSnapshot.child("longitude").getValue(Double.class));
            nama = new String(dataSnapshot.child("nama").getValue(String.class));
            kec = new String(dataSnapshot.child("kecamatan").getValue(String.class));
            kab = new String(dataSnapshot.child("kebupaten").getValue(String.class));

            googleMap.addMarker(new MarkerOptions().position(newlocation).title(nama+", "+kec+", "+kab));
            myCallback.onCallback(newlocation);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {}
    });
}