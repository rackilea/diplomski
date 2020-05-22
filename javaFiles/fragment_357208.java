DatabaseReference reff = FirebaseDatabase.getInstance().getReference("Cart List");
    final DatabaseReference reff2= FirebaseDatabase.getInstance().getReference("Cart List");

    reff.child("user View").child("09553706928").child("Products").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for(DataSnapshot snap: dataSnapshot.getChildren()){
                String getDate = snap.getKey();
                reff2.child("user View").child("09553706928").child("Products").child(getDate).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot snap1: dataSnapshot.getChildren()){
                            String myProductName = snap1.child("ProductName").getValue(String.class);
                            Toast.makeText(getApplicationContext(),myProductName,Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });