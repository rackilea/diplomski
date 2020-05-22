DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference allBooksRef = rootRef.child("All_Books");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Book> bookModelList = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Book book = ds.getValue(Book.class);
            bookModelList.add(book);
        }
        ListView list = (ListView) findViewById(R.id.listView);
        CustomListAdapter adapter = new CustomListAdapter(AdminFeed.this, bookModelList);
        list.setAdapter(adapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
allBooksRef.addListenerForSingleValueEvent(valueEventListener);