DatabaseReference reference = database.getReference("Companies");
reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
             if(childSnapshot.child("jaq").exists()){
               Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
             }
       }
  }
      @Override
     public void onCancelled(DatabaseError databaseError) {
      }
  });