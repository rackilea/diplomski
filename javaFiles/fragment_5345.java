ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()) {
            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                Book book = ds.getValue(Book.class);
                Log.d("TAG", book.getNameInEnglish());
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
};
authorIdOneRef.addListenerForSingleValueEvent(valueEventListener);