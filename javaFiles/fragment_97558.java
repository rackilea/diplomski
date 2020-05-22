DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query lastQuery = rootRef.child("sensor").orderByKey().limitToLast(1);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String detection = ds.child("Detection").getValue(String.class);
            Log.d(TAG, detection);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
lastQuery.addListenerForSingleValueEvent(valueEventListener);