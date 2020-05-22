databaseStatus.child(uid).addValueEventListener(new ValueEventListener() {

    @Override
    public void onDataChange(DataSnapshot snapshot) {

        for (DataSnapshot ds : snapshot.getChildren()) {

            for (DataSnapshot dSnapshot : ds.getChildren()) {

                String date=dataSnapshot.child("date").getValue().toString();
  String detail=dataSnapshot.child("detail").getValue().toString();
  String email=dataSnapshot.child("email").getValue().toString();
  String id=dataSnapshot.child("id").getValue().toString()
   //and so on
            }