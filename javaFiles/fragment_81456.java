DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference orderRef = rootRef.child("Order");
Query query = orderRef.orderByChild("mcustDeliveryStatus").equalTo("Pending");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        long count = dataSnapshot.getChildrenCount();
        if (count > 0) {
            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                String mGasBand = ds.child("mGasBand").getValue(String.class);
                Log.d(TAG, mGasBand);
            }
        } else {
            Log.d(TAG, "No data!");
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
query.addListenerForSingleValueEvent(valueEventListener);