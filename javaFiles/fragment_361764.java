DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference studentsListRef = rootRef.child("studentsList");
Query query = studentsListRef.orderByChild("name");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String name = ds.child("name").getValue(String.class);
            String key1 = ds.child("batch").child("0").getValue(String.class);
            String key2 = ds.child("batch").child("1").getValue(String.class);
            Log.d("TAG", name + " / " + key1 + " / " + key2);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(eventListener);