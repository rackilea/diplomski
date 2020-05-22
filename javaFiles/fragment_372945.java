DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference jobsRef = rootRef
        .child("USERS")
        .child("04950F4AE53F80")
        .child("JOBS");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String jobDate = ds.child("JOBOVERVIEW").child("jobDate").getValue(String.class);
            Log.d("TAG", jobDate);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
jobsRef.addListenerForSingleValueEvent(eventListener);