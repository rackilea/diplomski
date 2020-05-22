DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Trading info");
databaseReference.orderbyChild("TO location").equals("USA").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
         for(DataSnapshot ds : dataSnapshot.getChildren()){
           String fromLocation    = ds.child("FROM location").getValue(String.class);
           String passingLocation = ds.child("PASSING location").getValue(String.class);

              DatabaseReference voluneterService = FirebaseDatabase.getInstance().getReference("Volunteer services");
              voluneterService.orderbyChild("FROM location").equals(fromLocation).addValueEventListener(new ValueEventListener() {
                   @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        String fromLocation    = ds.child("availability").getValue(String.class);
                        String passingLocation = ds.child("email").getValue(String.class);
                        }
                     }
                    @Override
              public void onCancelled(DatabaseError databaseError) {
                     throw databaseError.toException();
                   }
                });
          }
    }
    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
});