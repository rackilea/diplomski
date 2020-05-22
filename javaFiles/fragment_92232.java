DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("Buses").orderByChild("Bus_Driver").equalsTo("xyz");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String Bus_Driver = ds.child("Bus_Driver").getValue(String.class);
            Log.d(TAG, Bus_Driver);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
query.addListenerForSingleValueEvent(valueEventListener);