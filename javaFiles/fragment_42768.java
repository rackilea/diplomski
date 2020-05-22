DatabaseReference db = (DatabaseReference) 
        FirebaseDatabase.getInstance().getReference().child("id");

        db.orderByValue().equalTo(p1ID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot val : dataSnapshot.getChildren()){
                    data = val.toString();

                    Log.e("HALLO", data);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });