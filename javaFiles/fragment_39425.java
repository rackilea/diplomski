userRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String firstName = dataSnapshot.child("firstName").getValue(String.class);
        String lastName = dataSnapshot.child("lastName").getValue(String.class);
        ...
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        throw databaseError.toException(); // don't ignore errors
    }
});