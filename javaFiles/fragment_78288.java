DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference userRef = rootRef.child("Users").child("mido4@hotmail,com");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()) {
            String firstName = dataSnapshot.child("firstname").getValue(String.class);
            String lastName = dataSnapshot.child("lastname").getValue(String.class);
            Log.d("TAG", firstName + " " + lastName);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
usersRef.addListenerForSingleValueEvent(eventListener);