FirebaseDatabase.getInstance().getReference().child("Posts")
        .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        //here is your every post 
                        String key = snapshot.getKey(); 
                        Object value = snapshot.getValue();
                    }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });