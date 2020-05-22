DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference imagesListRef = rootRef.child("images_list");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int count = (int) dataSnapshot.getChildrenCount(); //Cast long to int
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
imagesListRef.addListenerForSingleValueEvent(valueEventListener);