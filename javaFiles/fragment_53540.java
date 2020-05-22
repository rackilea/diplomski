settingsRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                // easy
                String value = dataSnapshot1.getValue(String.class);                    
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });