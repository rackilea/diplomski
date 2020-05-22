seenRef.addValueEventListener(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
     for(DataSnapshot snapshot : dataSnapshot.getChildren()){

      String pushMessage = snapshot.getKey();
      dataSnapshot.child(pushMessage).child("Seen").setValue(true);



}

  }

  @Override
  public void onCancelled(DatabaseError databaseError) {
    System.out.println("The read failed: " + databaseError.getCode());
  }
});