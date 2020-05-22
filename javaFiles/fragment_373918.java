mDatabase= FirebaseDatabase.getInstance().getReference().child("books");
String newBid = mDatabase.push().getKey();
mDatabase.child(newBid).setValue(userValues, new DatabaseReference.CompletionListener() {
        @Override
        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
           System.out.println(databaseError);
        }
    });