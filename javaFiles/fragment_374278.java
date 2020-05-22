DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference firebaseDatabasePhoneNumbersRef = rootRef.child("firebaseDatabasePhoneNumbers");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> firebaseDatabaseList = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String firebaseDatabasePhoneNumber = ds.getKey();
            firebaseDatabaseList.add(firebaseDatabasePhoneNumber);
        }

        for(String phoneBookNumber : phoneBookList) {
            if (firebaseDatabaseList.contains(phoneBookNumber)) {
                finalList.add(phoneBookNumber);
            }
        }

        //Do what you need to do with the finalList
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
firebaseDatabasePhoneNumbersRef.addListenerForSingleValueEvent(valueEventListener);