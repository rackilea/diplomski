DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference unicaribeRef = rootRef.child("Unicaribe");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int total = 0;
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            int value = ds.getValue(Integer.class);
            total =+ value;
        }
        Log.d("TAG", String.valueOf(total));
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
unicaribeRef.addListenerForSingleValueEvent(eventListener);