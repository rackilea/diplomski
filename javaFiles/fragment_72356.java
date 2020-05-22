mGeofireDB = FirebaseDatabase.getInstance().getReference("Locations");
mUsersDB = FirebaseDatabase.getInstance().getReference("users");
GeoFire geofire = new GeoFire(mGeofireDB);
GeoQuery geoQueryNearByUser=null;

GeoQueryEventListener geoQueryEventListener=new GeoQueryEventListener() {
    // user has been found within the radius:
    @Override
    public void onKeyEntered(String key, GeoLocation location) {
        Log.d("MainActivity", "User " + key + " just entered the radius. Going to display it as a potential match!");
        nearbyUsersList.add(key);
        mUsersDB.child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    if (dataSnapshot.child("Sex").getValue() != null) {
                        if (dataSnapshot.exists()
                                && !dataSnapshot.child("Connections").child("NoMatch").hasChild(mCurrentUserID)
                                && !dataSnapshot.child("Connections").child("YesMatch").hasChild(mCurrentUserID)
                                && !dataSnapshot.getKey().equals(mCurrentUserID)
                                // TODO display users based on current user sex preference:
                                && dataSnapshot.child("Sex").getValue().toString().equals(mCurrentUserOppositeSex)
                                // location check:
                                && nearbyUsersList.contains(dataSnapshot.getKey())
                                ) {
                            String profilePictureURL = "default";
                            if (!dataSnapshot.child("ProfilePictureURL").getValue().equals("default")) {
                                profilePictureURL = dataSnapshot.child("ProfilePictureURL").getValue().toString();
                            }
                            // POPULATE THE CARD WITH THE DATABASE INFO:
                            Log.d("MainActivity", dataSnapshot.getKey() + " passed all the match checks!");
                            Card potentialMatch = new Card(dataSnapshot.getKey(), dataSnapshot.child("Name").getValue().toString(), profilePictureURL);
                            mCardList.add(potentialMatch);
                            mCardArrayAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onKeyExited(String key) {
        Log.d("MainActivity", "User " + key + " just exited the radius.");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mCardList.removeIf(obj -> obj.getUserID().equals(key));
            mCardArrayAdapter.notifyDataSetChanged();
            Log.d("MainActivity", "User " + key + " removed from the list.");
        } else {
            Log.d("MainActivity", "User should have exited the radius but didn't! TODO support older versions of Android!");
        }
    }

    @Override
    public void onKeyMoved(String key, GeoLocation location) {

    }

    // all users within the radius have been identified:
    @Override
    public void onGeoQueryReady() {
    }

    @Override
    public void onGeoQueryError(DatabaseError error) {

    }
};