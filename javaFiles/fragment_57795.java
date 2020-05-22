FirebaseDatabase database = FirebaseDatabase.getInstance();
FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
String userId=user.getUid();
DatabaseReference dbref = FirebaseDatabase.getInstance().getReference("Users/Clients").child(userId);
 dbref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String names=dataSnapshot.child("name").getValue().toString();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});