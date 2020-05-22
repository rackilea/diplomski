DatabaseReference reference = FirebaseDatabase.getInstance().getReference("posts");

reference.orderByChild("title").equalTo("test").addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
  for(DataSnapshot datas: dataSnapshot.getChildren()){
     String keys=datas.getKey();
    }
 }
@Override
public void onCancelled(DatabaseError databaseError) {
    }
 });