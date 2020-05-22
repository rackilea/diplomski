DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("users").orderByChild("isStaff").equalsTo(true);
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String email = ds.child("email").getValue(String.class);
            Log.d("TAG", email);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(eventListener);