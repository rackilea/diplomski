String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference userTeamRef = rootRef.child("User").child(uid).child("team");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String teamName = ds.getValue(String.class);
            Log.d("TAG", teamName);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
userTeamRef.addListenerForSingleValueEvent(valueEventListener);