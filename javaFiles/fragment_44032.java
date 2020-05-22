mFirebaseRef = new Firebase("https://yours.firebaseio.com");
    mFirebaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot child: dataSnapshot.getChildren()) {
                Log.i("MainActivity", child.getKey());
            }
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {
            Log.e("MainActivity", "onCancelled", firebaseError.toException());
        }
    });