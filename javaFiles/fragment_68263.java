public void getListOfUsernames(){

eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
            User user = snapshot.getValue(User.class);

            Usernames.add("" + user.name);
            MNumbers.add("" + user.phone);
        }

        String UserNumber = mUser.getPhoneNumber();

        if (MNumbers.contains(UserNumber)){
            cancleProgress();
            startActivity(new Intent(UsernameActivity.this,ProfileActivity.class));
        }

        cancleProgress();

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
    }
};

mRef.child("Usernames").addValueEventListener(eventListener);

}