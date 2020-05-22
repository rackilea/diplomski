DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users");
databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
 public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
         String key = ds.getKey();
         String name = ds.child("name").getValue().toString();
     }
}

 @Override
public void onCancelled(DatabaseError databaseError) {
 }
});