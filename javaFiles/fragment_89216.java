mydb.child("users").child(uid).child("inventory").addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
      Log.d("itemname", childSnapshot.getChild("name").getValue());
      Item item = childSnapshot.getValue(Item.class);
      Log.d("itemname",item.getName());
    }
  }
  @Override
  public void onCancelled(DatabaseError databaseError) {
    throw databaseError.toException(); // don't ignore errors
  }
}