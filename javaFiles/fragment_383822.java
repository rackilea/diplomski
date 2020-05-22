DatabaseReference rootRef = FirebaseDatabase.getInstance().getRef();
Query locations = rootRef.orderByKey();
locations.addListenerForSingleValueEvent(new ValueEventListener() {
  public void onDataChange(DataSnapshot snapshot) {
    for (DataSnapshot locSnapshot: snapshot.getChildren()) {
        System.out.println(locSnapshot.getKey() + ": " + locSnapshot.getValue(String.class));
    }
  }

  public void onCancelled(DatabaseError databaseError) {
    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
    // ...
  }
});