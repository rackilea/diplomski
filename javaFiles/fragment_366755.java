FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
String uid=user.getUid();
DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Workers");
ref.addSingleValueEventListener(new ValueEventListener(){
  @Override
 public void onDataChange(DataSnapshot dataSnapshot) {
     for(DataSnapshot datas: dataSnapshot.getChildren()){
        String plumbers=datas.getKey();

    DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("RequestService").child(plumbers).child(uid);
    ref.addSingleValueEventListener(new ValueEventListener(){
     @Override
     public void onDataChange(DataSnapshot dataSnapshot) {
        String fees=dataSnapshot.child("ServiceFee").getValue().toString();
     }
     @Override
     public void onCancelled(FirebaseError firebaseError) {

       }
    });
  }

    @Override
  public void onCancelled(FirebaseError firebaseError) {

   }
});