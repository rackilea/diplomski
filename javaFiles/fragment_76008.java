DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference itemsRef = rootRef.child("items");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String foodName = ds.child("Food Name").getValue(String.class);
            list.add(foodName);
        }
        Log.d("TAG", list);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
itemsRef.addListenerForSingleValueEvent(valueEventListener);