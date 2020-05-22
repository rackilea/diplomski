DatabaseReference usersRef = db.getReference("users");
usersRef.orderByChild("email")
        .equalTo("tom@mymail.com")
        .addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()) {
           //exists!
        }
        else {
           //does not exist
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {                            
    }
});