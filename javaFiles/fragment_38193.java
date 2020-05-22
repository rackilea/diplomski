reference.orderByChild(userid).equalTo(userid).addListenerForSingleValueEvent(
    new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            DataSnapshot lastSnapshot = null;
            for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {               
              lastSnapshot = childSnapshot;
            }
            if (lastSnapshot != null) {
                lastSnapshot.getRef().removeValue();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            throw databaseError.toException(); // never ignore errors   
        }
    }
);