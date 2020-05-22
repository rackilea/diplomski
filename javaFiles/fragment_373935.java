/* 1 */    dbuser = FirebaseDatabase.getInstance().getReference("Passanger");
/* 2 */    dbuser.addListenerForSingleValueEvent(new ValueEventListener() {
/* 3 */        @Override
/* 4 */        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
/* 5 */            for (DataSnapshot datas : dataSnapshot.getChildren()) {
/* 6 */                String dbmobileno = datas.child("mobileno").getValue().toString();
               ...
/* 7 */        public void onCancelled(@NonNull DatabaseError databaseError) {
/* 8 */        }
/* 9 */    });
/*10 */    System.out.println("Got here");