String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference gigPostsRef = rootRef.child("users").child(uid).child("Gig posts");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String amount = ds.child("amount").getValue(String.class);
            String description = ds.child("description").getValue(String.class);
            String firstLetter = ds.child("firstLetter").getValue(String.class);
            String name = ds.child("name").getValue(String.class);
            Log.d("TAG", amount + " / " + description + " / " + firstLetter + " / " + name);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
gigPostsRef.addListenerForSingleValueEvent(eventListener);