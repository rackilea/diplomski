DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
databaseReference= rootRef.child("appointment");
databaseReference.orderByChild("userid").equalTo(userid1).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
        for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
            String theraid = dataSnapshot1.child("theraid").getValue(String.class);
            DatabaseReference userRef = rootRef.child("alluser/thera").child(theraid);
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot userSnapshot) {
                    String name = userSnapshot.child("name").getValue(String.class);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    throw databaseError.toException();
                }
            }
        }
       adapter=new MyRecyclerviewPAppointment(MainActivityPAppointment.this, a,namelist);
        rv.setAdapter(adapter);

    }