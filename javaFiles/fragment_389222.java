DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("unknown").child("Shrubs");
ref.addValueEventListener(new ValueEventListener(){
 @Override
 public void onDataChange(DataSnapshot dataSnapshot) {
  for(DataSnasphot datas: dataSnapshot.getChildren()){
     String name=datas.child("ShrubbedWord").getValue().toString();
    } 
 }

@Override
public void onCancelled(FirebaseError firebaseError) {


    }
   });