FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
DatabaseReference reference = FirebaseDatabase.getInstance().getReference("event").child(user.getUid());;

reference.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
   String eventname=datas.child("eventName").getValue().toString();
   String eventsport=datas.child("eventSport").getValue().toString();
    }
 }
 @Override
public void onCancelled(DatabaseError databaseError) {
  }
 });