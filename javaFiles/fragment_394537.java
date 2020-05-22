DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference settingsRef = rootRef.child(name).child("Settings");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
            String name = dataSnapshot.child("Name").getValue(String.class);
            String password = dataSnapshot.child("Password").getValue(String.class);
            Log.d("TAG", name + " / " + password);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
settingsRef.addListenerForSingleValueEvent(valueEventListener);