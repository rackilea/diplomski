DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference usersRef = rootRef.child("users");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String uid = ds.getKey();
            Log.d("TAG", uid);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
usersRef.addListenerForSingleValueEvent(valueEventListener);