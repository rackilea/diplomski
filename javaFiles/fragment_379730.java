DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference diarrheaRef = rootRef.child("symptomList").child("Bloating").child("Diarrhea");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String name = ds.getKey();
            Log.d("TAG", name);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
diarrheaRef.addListenerForSingleValueEvent(eventListener);