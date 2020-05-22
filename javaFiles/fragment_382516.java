DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference buildingsRef = rootRef.child("buildings");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> list = new ArrayList<>();
        for(DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
            for(DataSnapshot ds : dSnapshot.child("floors").getChildren()) {
                for(DataSnapshot d : ds.getChildren()) {
                    String key = d.getKey();
                    String description = d.child("description").getValue(String.class);
                    list.add(key);
                    Log.d("TAG", key);
                }
            }
        }

        //Do what you need to do with your list
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d("TAG", databaseError.getMessage());
    }
};
buildingsRef.addListenerForSingleValueEvent(valueEventListener);