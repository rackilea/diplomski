db.child("Leads").child("Generated").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists())
            {
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    SomeClass someClass = ds.getValue(SomeClass.class);
                    if(someClass.getUid().equals("uid")){
                        // i don't if it is the best practice or not but you can do with this as well
                    }
                }
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });