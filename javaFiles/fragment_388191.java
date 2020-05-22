firebase.child("key").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot innerDataSanpShot : dataSnapshot.getChildren()) {
              //DataSnapshot of inner Childerns
              String username = innerDataSnapShot.child("username").getValue().toString();
             } 
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    });