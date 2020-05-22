DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Lectures").child("Saturday,March 03");

reference.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
   String batchname=datas.child("batch_name").getValue().toString();
          //etc
     }
  }
    @Override
   public void onCancelled(DatabaseError databaseError) {
  }
  });