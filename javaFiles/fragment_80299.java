Firebase ref = new Firebase("YOUR-URL-HERE/PATH/TO/YOUR/STUFF");

ref.addChildEventListener(new ChildEventListener() {
    public void onChildAdded(DataSnapshot dataSnapshot, String previousKey) {
    }
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
    }
    public void onChildRemoved(DataSnapshot dataSnapshot) {
    }
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
    }
    public void onCancelled(FirebaseError firebaseError) { }
});