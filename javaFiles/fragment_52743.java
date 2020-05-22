public static void addUser() {
    final String email = Tools.getEmail();
    DatabaseReference grayRef = FirebaseDatabase.getInstance().getReference().child("graylist");

    // Search the graylist for the email specified.
    grayRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onCancelled(DatabaseError dbe) {}

        @Override
        public void onDataChange(DataSnapshot snap) {
            boolean found = false;
            Iterable<DataSnapshot> graylist = snap.getChildren();
            for(DataSnapshot gray : graylist) {
                String uid = gray.getKey();
                String em = gray.getValue(String.class);
                if(em.equals(email)) {
                    found = true;
                    // We found the one we're looking for. Insert its UID into the whitelist.
                    DatabaseReference whiteRef = FirebaseDatabase.getInstance().getReference().child("whitelist");
                    whiteRef.child(uid).setValue(email, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError dbe, DatabaseReference dbr) {
                            complete[0] = true;
                            if(dbe != null) {
                                System.err.println("Error adding user to whitelist!");
                                dbe.toException().printStackTrace();
                            } else {
                                Platform.runLater(() -> {                                  
                                    ParselyMain.createAlert(AlertType.CONFIRMATION, "User Added", "User added to the whitelist!");
                                });
                            }
                        }
                    });
                    break;
                }
            }
            if(!found) {
                Platform.runLater(() -> {
                    ParselyMain.createAlert(AlertType.INFORMATION, "User Not Found", "That user was not found in the graylist!");
                });
            }
        }
    });
}