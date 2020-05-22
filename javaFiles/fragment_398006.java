myRef.orderByChild("email").equalTo(email).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
            String status = childSnapshot.child("status").getValue(String.class);
        }
    }