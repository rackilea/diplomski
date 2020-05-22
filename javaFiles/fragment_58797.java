FirebaseDatabase database = FirebaseDatabase.getInstance();
ref = database.getReference("RECORD");
String check = "CTJZNO5pU2RzlAQa7ol5OlQoTmU2/dailyData/1557360000000/";

ref.child(check).addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
   Integer value = dataSnapshot.child("dailyTotalDis").getValue(Integer.class);
   if(value.equalsTo(5.8))
        ref.child(check).child("dailyRank").setValue("1");
}

@Override
public void onCancelled(FirebaseError firebaseError) {
  }
});