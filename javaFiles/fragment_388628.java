Query query = FirebaseDatabase.getInstance().getReference().child("promoCodes").orderByChild("promoCode").equalTo(promoCodeString);
query.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
      if (promoUnapplied) {
        for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
            String amount = snapshot.child("amount").getValue(String.class);
            double bill = Double.valueOf(theBillTA.getText().toString());
            double billAfterDis = bill * Double.valueOf(amount) / 100;
            bill -= billAfterDis;
            ...