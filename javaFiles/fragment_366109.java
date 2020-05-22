DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("GeoFire");
ref.orderByChild("lattitude").equalTo(lattitude_here).addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
  String userID=datas.getKey();
    }
 }
 @Override
public void onCancelled(DatabaseError databaseError) {
   }
});