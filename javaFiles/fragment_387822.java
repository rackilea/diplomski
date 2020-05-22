database = FirebaseDatabase.getInstance();
commu = database.getReference("Community");

commu.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           for(DataSnapshot ds : dataSnapshot.getChildren()){
                count= ds.child("count").getValue(Long.class);
               }
           }
 .....