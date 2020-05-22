DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ref = rootRef.child("ExchangeItemsData");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
            for(DataSnapshot ds : dSnapshot.getChildren()) {
                String imageUrl = ds.child("imageUrl").getValue(String.class);
                String phoneNo = ds.child("phoneNo").getValue(String.class);
                String productDesc = ds.child("productDesc").getValue(String.class);
                String productName = ds.child("productName").getValue(String.class);
                String userID = ds.child("userID").getValue(String.class);
                Log.d(TAG, productName);
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
ref.addListenerForSingleValueEvent(valueEventListener);