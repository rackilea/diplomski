FCGames.orderByKey()
       .limitToFirst(1)
       .addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
            wagerr = snapshot.child("wager").getValue(Long.class);
            String wagerD = Double.toString(wagerr);
            wage = wagerD.endsWith("0");

            wagerCallback.onCallback(wagerD);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        throw databaseError.toException(); // don't ignore errors
    }
});