DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference blogRef = rootRef.child("Blog");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String desc = ds.child("desc").getValue(String.class);
            String title = ds.child("title").getValue(String.class);
            String image = ds.child("image").child("path").getValue(String.class);
            Log.d("TAG", desc + " / " + title + " / " + image);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
blogRef.addListenerForSingleValueEvent(eventListener);