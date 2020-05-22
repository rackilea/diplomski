DatabaseReference usersRef = ref.child("users");
userRef.addValueEventListener(new ValueEventListener() {
    @Override public void onDataChange (DataSnapshot dataSnapshot){
        // code here does not get executed straight away,
        // it gets executed whenever data is received back from the remote database
    }


});