DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ingridientsRef = rootRef.child("Receptes").child("Ingridients");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String ingridient = ds.getKey();
            Log.d("TAG", ingridient);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
ingridientsRef.addListenerForSingleValueEvent(valueEventListener);