ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String name = ds.child("name").getValue(String.class);
            Log.d(TAG, name);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
query.addListenerForSingleValueEvent(valueEventListener);