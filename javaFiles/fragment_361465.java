val ref = FirebaseDatabase.getInstance().getReference("users").child(uid).child("randomInt")

ref.runTransaction(new Transaction.Handler() {
    @Override
    public Transaction.Result doTransaction(MutableData mutableData) {
        Long value = mutableData.getValue(Long.class);
        if (p == null) {
            mutableData.setValue(1L);
            return Transaction.success(mutableData);
        }
        else {
            mutableData.setValue(value + 1);
        }

        return Transaction.success(mutableData);
    }

    @Override
    public void onComplete(DatabaseError databaseError, boolean b,
                           DataSnapshot dataSnapshot) {
        Log.d(TAG, "transaction:onComplete:" + databaseError);
    }