mDatabase = FirebaseDatabase.getInstance().getReference().child("Product");
//Put this code here, after the mDatabase
mDatabase.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
    if (dataSnapshot.exists()) {
        int totalPrice = 0;
        for (DataSnapshot snapShot : dataSnapshot.getChildren()) {
            if (snapShot.exists()) {
                int size = snapShot.child("p_price").getValue(Integer.class);
                totalPrice += size;

            //Display total
            textViewTotal.setText(String.valueOf(totalPrice));
        }
    }
   }

   @Override
   public void onCancelled(@NonNull DatabaseError databaseError) {

   }
});