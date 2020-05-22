DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("chat_id");
ref.addValueEventListener(new ValueEventListener(){
 @Override
public void onDataChange(DataSnapshot dataSnapshot){
  if(dataSnapshot.exist() {

      }
    }
  @Override
public void onCancelled(DatabaseError databaseError) {

     }
 });