DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference postsRef = rootRef.child("Posts").child("Posts");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String message = ds.child("Message").getValue(String.class);
            Log.d("TAG", message);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
postsRef.addListenerForSingleValueEvent(valueEventListener);