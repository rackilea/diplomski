statusRef = database.getReference("reserva/1/status");
statusRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String status = dataSnapshot.getValue(String.class);
    }
    ...