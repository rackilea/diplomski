ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()) {
            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                String nameInEnglish = ds.child("nameInEnglish").getValue(String.class);
                Log.d("TAG", nameInEnglish);
            }
        }           
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
};
authorIdOneRef.addListenerForSingleValueEvent(valueEventListener);