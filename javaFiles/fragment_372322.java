DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference();
databaseUsers.orderByChild("user").equalTo("Admin").addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
    for(DataSnapshot ds : dataSnapshot.getChildren()){
   String password = ds.child("password").getValue(String.class);
    }
 }
   @Override
public void onCancelled(DatabaseError databaseError) {
   throw databaseError.toException();
  }
 });