@Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
        for (DataSnapshot child : children) {
            BookObject book = child.getValue(BookObject.class);
            books.add(book);
        }
        CatalogAdapter catalogAdapter = new CatalogAdapter(this, books);
        catalogListView.setAdapter(catalogAdapter);
    }