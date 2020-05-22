String phoneNo = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("posts").child(phoneNo).orderByChild("timestamp");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String content = ds.child("content").getValue(String.class);
            Log.d("TAG", content);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);