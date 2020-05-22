poiFirebase.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        //...
        mapReset();
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        //...
        mapReset();
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        //...
        mapReset();
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
        //...
        mapReset();
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {
        //...
    }
});