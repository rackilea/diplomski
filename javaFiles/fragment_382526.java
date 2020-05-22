reference.runTransaction(new Transaction.Handler() {
    @Override
    public Transaction.Result doTransaction(MutableData mutableData) {
        if (mutableData.getValue() == null) {
            mutableData.setValue(1);
        } else {
            int count = mutableData.getValue(Integer.class);
            mutableData.setValue(count + 1);
        }
        return Transaction.success(mutableData);
    }

    @Override
    public void onComplete(DatabaseError databaseError, boolean success, DataSnapshot dataSnapshot) {
        // Analyse databaseError for any error during increment
    }
});