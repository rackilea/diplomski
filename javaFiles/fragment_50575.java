DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference userBanknoteAmountRef = rootRef.child("userBanknoteAmount");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            UserBanknoteAmountBindModel userBanknoteAmountBindModel = ds.getValue(UserBanknoteAmountBindModel.class);
            String banknoteAmount = userBanknoteAmountBindModel.getBanknoteAmount();
            String banknoteType = userBanknoteAmountBindModel.getBanknoteType();
            String userId = userBanknoteAmountBindModel.getUserId();
            Log.d("TAG", banknoteAmount + " / " + banknoteType + " / " + userId);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
userBanknoteAmountRef.addListenerForSingleValueEvent(valueEventListener);