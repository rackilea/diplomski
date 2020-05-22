private DatabaseReference mDataBaseRef;
mDataBaseRef= FirebaseDatabase.getInstance().getReference()

ValueEventListener postListener = new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    int youtItemId = dataSnapshot.child("user").child("yourItemId").getValue(Integer.class);
}

@Override
public void onCancelled(DatabaseError databaseError) {
    // Log the message from databaseError
  }
};

mDataBaseRef.addValueEventListener(postListener);