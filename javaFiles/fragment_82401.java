DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference eventsRef = rootRef.child("events");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
            DataSnapshot participantsSnapshot = snapshot.child("participants");
            for(DataSnapshot ds : participantsSnapshot.getChildren()) {
                String uid = ds.getValue(String.class);
                Log.d(TAG, uid);
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
eventsRef.addListenerForSingleValueEvent(valueEventListener);