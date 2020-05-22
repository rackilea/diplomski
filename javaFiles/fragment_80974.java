myRef.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        String key = dataSnapshot.getKey();
        Item item = dataSnapshot.getValue(Item.class);
        myArrayList.add(key+": "+item.description+" ("+item.quantity+")");
        myArrayAdapter.notifyDataSetChanged();
    }