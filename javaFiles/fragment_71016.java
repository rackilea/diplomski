Query newQuery = database.getReference("users");
newQuery.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
           String fname=dataSnapshot.child("firstName").getValue().toString();
            Toast.makeText(DBActivity.this, friends.firstName, Toast.LENGTH_SHORT).show();
        }
    }