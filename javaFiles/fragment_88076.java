reference.child(postid).child("location").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        double latitude = dataSnapshot.child("latitude").getValue(Double.class);
        double longitude = dataSnapshot.child("longitude").getValue(Double.class);

        ...
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});