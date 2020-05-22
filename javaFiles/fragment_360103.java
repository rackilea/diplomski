DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Categories");
ref.addValueEventListener(new ValueEventListener(){
 @Override
 public void onDataChange(DataSnapshot dataSnapshot) {
  for(DataSnasphot datas: dataSnasphot.getChildren()){
  String num=datas.child("1").getValue().toString();
  String twos=datas.child("2").getValue().toString();
  String threes=datas.child("3").getValue().toString();
  String four=datas.child("4").getValue().toString();
  //so on
 }

 }

 @Override
public void onCancelled(FirebaseError firebaseError) {


 }
});