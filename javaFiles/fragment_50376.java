database.getReference("employees").orderByChild("employeeName").equalTo("semah").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot child: dataSnapshot.getChildren()) {
                child.getRef().setValue(null);
            }
        }


       @Override
         public void onCancelled(DatabaseError databaseError) {
              Log.w("TodoApp", "getUser:onCancelled", databaseError.toException());
         }
});