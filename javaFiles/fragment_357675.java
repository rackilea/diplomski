private void getBooks(){
    DatabaseReference showBookRef = databaseReference.child("Books").child("oJ26QDoFZBWAgWjxbFOX5jv1tcG3");

    showBookRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                for (DataSnapshot data:dataSnapshot.getChildren()){
                    Book book = data.child("BookInfo").getValue(Book.class);
                    bookList.add(book);
                    bookAdapter.notifyDataSetChanged();
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}