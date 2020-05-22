myRef.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        String key = dataSnapshot.getKey();
        String description = dataSnapshot.child("Description").getValue(String.class);
        Long quantity = dataSnapshot.child("Quantity").getValue(Long.class);
        myArrayList.add(key+": "+description+" ("+quantity+")");
        myArrayAdapter.notifyDataSetChanged();
    }