FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
String userid=user.getUid();
DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(userid);

reference.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {

   String address=dataSnapshot.child("address").getValue().toString();
   String name=dataSnapshot.child("name").getValue().toString();
    userName.setText(name);


 }
 @Override
public void onCancelled(DatabaseError databaseError) {
    }
 });