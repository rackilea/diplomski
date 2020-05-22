DatabaseReference db = FirebaseDatabase.getInstance().getReference();

Query mSeenRef = db.child("Messages").child(MessageRecieverId).child(MessageSenderId).orderByChild("From").equalTo(MessageRecieverId);
mSeenRef.addValueEventListener(new ValueEventListener(){
 @Override
public void onDataChange(DataSnapshot dataSnapshot){
  if(dataSnapshot.exist()) {
     for(DataSnapshot ds: dataSnapshot.getChildren()){
          String keyId=ds.getKey();
         DatabaseReference ref= db.child("Messages").child(MessageRecieverId).child(MessageSenderId).child(keyId);
         Map<String, Object> childUpdates = new HashMap<>();
             childUpdates.put("Seen", true);
             ref.updateChildren(childUpdates);
        }
      }
    }
@Override
public void onCancelled(DatabaseError databaseError) {
  }
};