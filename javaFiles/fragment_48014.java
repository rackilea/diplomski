int index = 0;
mDatabase.child("data").addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
        Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

        // A new comment has been added, add it to the displayed list
        Data data = dataSnapshot.getValue(Data.class);
        index++;
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/data/" + dataSnapshot.getKey()+"/index", index);
        mDatabase.updateChildren(childUpdates);
    }