DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");

reference.orderByChild("firstName").equalTo(name).addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
   String familyname=datas.child("familyName").getValue().toString();
    }
 }
   @Override
public void onCancelled(DatabaseError databaseError) {
  }
 });