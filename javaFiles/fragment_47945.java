DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference classicalMechanicsRef = rootRef.child("books").child("Classical Mechanics").child("-LVmsTmBZ_kCdcXlZh7e");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        dataSnapshot.child("sellername").getRef().setValue("newvalue");
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
classicalMechanicsRef.addListenerForSingleValueEvent(valueEventListener);