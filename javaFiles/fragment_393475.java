ref.addListenerForSingleValueEvent(new ValueEventListener) {
  public void onDataChange(DataSnapshot snapshot) {
    if (dataSnapshot.exists()) {
      for (DataSnapshot userSnapshot : snapshot.getChildren()) {
        for (DataSnapshot programSnapshot : userSnapshot.getChildren()) {
          Program program = programSnapshot.getValue(Program.class);
      }
    }
  }

  public void onCancelled(FirebaseError firebaseError) {

  }
});