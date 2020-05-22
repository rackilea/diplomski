DatabaseReference fireReference = FirebaseDatabase.getInstance().getReference("students");

fireReference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        for(DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
            if(childSnapshot.hasChild(userKey)) {

                String userID = childSnapshot.child(userKey).child("level").getValue(String.class);

                break;
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});