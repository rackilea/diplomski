// Get DatabaseReference for All Machines
DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("All Machines");

// Use orderByChild to order data by terminal_Id and use equalTo for filter by newTerminal_id
Query query = databaseReference.orderByChild("terminal_Id").equalTo(newTerminal_id);

query.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot childSnapshot: dataSnapshot.getChildren()) {

            String Terminal_address= childSnapshot.child("address").getValue(String.class);
            String Terminal_name = childSnapshot.child("terminal_name").getValue(String.class);

            terminal_name.setText(Terminal_name);
            terminal_address.setText(Terminal_address);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});