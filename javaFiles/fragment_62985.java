public void setData(){
        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
        Query queryToGetData = dbRef.child("Biodata")
                .orderByChild("Email").equalTo("MyUser@email.com");
        queryToGetData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()){
                    String userId = dbRef.child("Biodata").push().getKey();
                    Biodata bio = new Biodata("MyUser", "MyUser@email.com");
                    dbRef.child("Biodata").child(userId).setValue(bio);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }