ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> phoneNumberList = new ArrayList<>();
        FileWriter writer = new FileWriter("output.txt");
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String phoneNumber = ds.child("phoneNumber").getValue(String.class);
            phoneNumberList.add(phoneNumber);
            writer.write(phoneNumber);
        }
        //Do what you need to do with your list
        Log.d(TAG, phoneNumberList.toString());
        writer.close();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
databasePhone.addListenerForSingleValueEvent(valueEventListener);