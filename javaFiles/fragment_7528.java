public void incrementCounter() {
    firebase.runTransaction(new Transaction.Handler() {
        @Override
        public Transaction.Result doTransaction(final MutableData currentData) {
            if (currentData.getValue() == null) {
                currentData.setValue(1);
            } else {
                currentData.setValue((Long) currentData.getValue() + 1);
            }

            return Transaction.success(currentData);
        }

        @Override
        public void onComplete(FirebaseError firebaseError, boolean committed, DataSnapshot currentData) {
            if (firebaseError != null) {
                Log.d("Firebase counter increment failed.");
            } else {
                Log.d("Firebase counter increment succeeded.");
            }
        }
    });
}