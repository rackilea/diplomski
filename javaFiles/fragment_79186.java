FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        final DatabaseReference root_ref = firebaseDatabase.getReference();

        root_ref.child("comments").child("KeKwGa5btKuDYr3yYq5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String commentWriterUid = dataSnapshot.child("commentWriterUid").getValue().toString();

                root_ref.child("users").equalTo(commentWriterUid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        // Do all stuff you went

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });