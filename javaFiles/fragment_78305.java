DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference yourRef = rootRef.child("Authenticated-Users");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        long count = dataSnapshot.getChildrenCount();
        Log.d("TAG", count + "");
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
yourRef.addListenerForSingleValueEvent(eventListener);