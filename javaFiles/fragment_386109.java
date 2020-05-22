String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("Mates").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<User> userList = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            User user = ds.getValue(User.class);
            userList.add(user);
            Log.d(TAG, user.getUsername() + " / " + user.getFullname());
        }

        //Do what you need to do with your userList
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
uidRef.addListenerForSingleValueEvent(valueEventListener);