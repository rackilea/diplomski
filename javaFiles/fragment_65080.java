String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.child("userType").getValue(String.class).equals("Customer")) {
            startActivity(new Intent(getApplicationContext(), UserMainPageActivity.class));
        } else if (dataSnapshot.child("userType").getValue(String.class).equals("Venue Owner")) {
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
uidRef.addListenerForSingleValueEvent(valueEventListener);