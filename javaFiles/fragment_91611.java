DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference yourRef = rootRef.child("Street Problems");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            for(DataSnapshot dSnapshot : ds.getChildren()) {
                StreetClass streetClass = dSnapshot.getValue(StreetClass.class);
                Log.d("TAG", streetClass.getName());
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
yourRef.addListenerForSingleValueEvent(eventListener);