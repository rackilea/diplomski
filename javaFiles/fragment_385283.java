if (user !=null){
            DatabaseReference myRef = database.getReference("users").child(user.getUid()).child("user_bio");

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()){
                        bio.setText(dataSnapshot.getValue(String.class));

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }