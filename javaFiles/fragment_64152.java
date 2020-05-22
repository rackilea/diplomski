database.getReference().child("Users").child(UserID).addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
        email.setText(dataSnapshot.child("email").getValue(String.class));
        String FN = dataSnapshot.child("firstName").getValue(String.class);
        Log.i("First Name", FN);
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
      }
    });