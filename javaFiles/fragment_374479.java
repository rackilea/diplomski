DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("Users").orderByChild("username");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Map<String, Object> map = (Map<String, Object>) ds.getValue();
            map.put("score", 0);
            ds.getRef().updateChildren(map);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
query.addListenerForSingleValueEvent(valueEventListener);