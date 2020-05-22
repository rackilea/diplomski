DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference classicalMechanicsRef = rootRef.child("books").child("Classical Mechanics");
Query query = classicalMechanicsRef.orderByChild("sellername").equalTo("sagar");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            ds.child("sellername").getRef().setValue("newvalue");
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
query.addListenerForSingleValueEvent(valueEventListener);