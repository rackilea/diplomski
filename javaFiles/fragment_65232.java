DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference downloadsRef = rootRef.child("Global_downloads").child(Apptype).child(downloadName).child("downloads");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int downloads = dataSnapshot.getValue(Integer.class);
        Log.d("TAG", downloads);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
downloadsRef.addListenerForSingleValueEvent(eventListener);