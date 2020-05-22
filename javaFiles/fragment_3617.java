List<String> prods = new ArrayList<>();
List<String> quantity = new ArrayList<>();

smsSendToBtn.setOnClickListener(new View.OnClickListener() {
    //private String Cart;

    public void onClick(View view) {

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference("Cart List");
        final DatabaseReference reff2= FirebaseDatabase.getInstance().getReference("Cart List");

        reff.child("User View").child(Prevalent.CurrentOnlineUsers.getPhone()).child("Products").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snap: dataSnapshot.getChildren()){
                    String getDate = snap.getKey();
                    reff2.child("User View").child(Prevalent.CurrentOnlineUsers.getPhone()).child("Products").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot snap1: dataSnapshot.getChildren()){

                                String myProductName = snap1.child("productName").getValue(String.class);
                                String myQuantity = snap1.child("quantity").getValue(String.class);
                                prods.Add(myProductName );
                                quantity.Add(myQuantity);

                                Toast.makeText(getApplicationContext(),myProductName + " " + myQuantity,Toast.LENGTH_SHORT).show();



                            }
                             setSMSData(prods,quantity);

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

    }