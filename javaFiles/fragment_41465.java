DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("CountLikes");

ref.addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    for(DataSnapshot child: dataSnapshot.getChildren()) {
      System.out.println(child.getKey()); // prints "Project 23", "Project 32", etc
      for(DataSnapshot grandchild: child.getChildren()) {
        System.out.println(grandchild.getKey()); // prints "Biological and Ecological", etc
        System.out.println(grandchild.child("Votes").getValue(Long.class)); // prints 1, 0, etc
      }

    }

 }

  @Override
  public void onCancelled(DatabaseError databaseError) {
    throw databaseError.toException();
  }
});