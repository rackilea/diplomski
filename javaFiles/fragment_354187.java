Firebase ref = mFirebaseRef.child(FirebaseReference.CHILD_FLIGHTS);
Query queryRef = ref.child("GOT").orderByChild("arrivalTime").equalTo("2016-06-21_GOT");
queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
   @Override
   public void onDataChange(DataSnapshot dataSnapshot) {

   }
});