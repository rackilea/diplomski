DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference eventsRef = rootRef.child("Events");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String userKey = ds.getKey();
            Log.d("TAG", userKey);
            eventsRef.child(userKey).child("event_key").setValue(true);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
eventsRef.addListenerForSingleValueEvent(eventListener);