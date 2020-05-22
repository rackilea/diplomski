String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference currentUserReference = databaseUsers.child(uid);
currentUserReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()) {
            User user = venueSnapshot.getValue(User.class);

            if(user.getAdminUser() == true)
            {
                buttonAddProducts.setVisibility(View.VISIBLE);
                buttonAddBeverages.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException(); // don't ignore exceptions
    }
});