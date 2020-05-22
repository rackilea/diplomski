DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference yourRef = rootRef.child("Street Problems");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            for(DataSnapshot dSnapshot : ds.getChildren()) {
                String sname = dSnapshot.child("sname").getValue(String.class);
                Log.d("TAG", sname);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
yourRef.addListenerForSingleValueEvent(eventListener);