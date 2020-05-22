FirebaseDatabase.getInstance().getReference("Block")
    .child("MyUUID")
    .child("specificUUID")
    .addValueEventListener(new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if(dataSnapshot.exists()) {
                // ... Do something
            } else {
                call_method();
            }
       // ... Other code
}