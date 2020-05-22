Firebase ref = mFirebaseRef.child(FirebaseReference.CHILD_FLIGHTS);
Query queryRef = ref.orderByChild("arrivalDate_code").equalTo("2016-06-21_GOT");
queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
   @Override
   public void onDataChange(DataSnapshot dataSnapshot) {

   }
});