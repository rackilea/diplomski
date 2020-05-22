databaseReference = FirebaseDatabase.getInstance().getReference();

databaseReference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot data : dataSnapshot.getChildren()){
            Author author = data.getValue(Author.class);
            authorList.add(author);
        }

        ...
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});