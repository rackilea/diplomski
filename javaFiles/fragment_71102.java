DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
System.out.println(retrievedValue); //this line returns null! 

ref.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        retrievedValue = (Long) dataSnapshot.getValue();

        System.out.println(retrievedValue); //this line works
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});