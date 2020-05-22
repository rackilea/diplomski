String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("Usuarios").child(uid);
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String name = dataSnapshotds.child("name").getValue(String.class);
        Log.d("TAG", name);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
uidRef.addListenerForSingleValueEvent(eventListener);