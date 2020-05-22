FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
String userid=user.getUid();

DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users").child(userid).child("contacts");

reference.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
   for(DataSnapshot datas: dataSnapshot.getChildren()){
    String dept=datas.child("dept").getValue().toString();
      //get other values
   }
}
 @Override
public void onCancelled(DatabaseError databaseError) {
  }
});