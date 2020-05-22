EventListener<DocumentSnapshot> eventListener = new EventListener<DocumentSnapshot>() {
    @Override
    public void onEvent(DocumentSnapshot snapshot, FirebaseFirestoreException e) {
        if (snapshot != null && snapshot.exists()) {
            //Do what you need to do
        }
    }
};