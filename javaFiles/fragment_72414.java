Query databaseReference = FirebaseDatabase.getInstance().getReference("Student").child("Ltlu0PZaSDgydS1akRt").orderByChild("-Lua7cZD1anNgKuvprjj");
databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
     if(dataSnapshot.exists()){
       for(DataSnapshot ds : dataSnapshot.getChildren()){
           String key = ds.getKey();
           String value = ds.getValue(String.class);
         } 
    }
} 
    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
});