String phoneNo = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("posts").child(phoneNo).orderByChild("timestamp");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            PostClass postClass = ds.getValue(PostClass.class);
            Log.d("TAG", postClass.getContent());
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);