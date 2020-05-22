TestNode.orderByKey().equalTo(TestKey).addListenerForSingleValueEvent(new ValueEventListener() {

 @Override
 public void onDataChange(DataSnapshot dataSnapshot) {
    Log.d("TEST","key: "+dataSnapshot.getKey());
    Log.d("TEST","value: "+dataSnapshot.getValue());
 }

 @Override
 public void onCancelled(DatabaseError databaseError) {}
 });