Firebase ref = new Firebase("https://YOUR-FIREBASE.firebaseio.com");    

ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        Long timestamp = (Long) snapshot.getValue();
        System.out.println(timestamp);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});

ref.setValue(ServerValue.TIMESTAMP);