mUsersDatabaseReference.orderByChild("VerificationStatus").equalTo("1").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        for(DataSnapshot child: dataSnapshot.getChildren()) {
            Users user = child.getValue(Users.class);
            if(user.getDesignation().equalsIgnoreCase("ADVOCATE")) {
                //Do your operation here
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

        SweetToast.error(AdvTalkActivity.this, "Unknown Error...");
    }
});