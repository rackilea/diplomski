CollectionReference reference = firestore.collection("app").document("store").collection("data");
reference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                Log.d(TAG, document.getId() + " => " + document.getData());
            }
        } else {
            Log.d(TAG, "Error getting documents: ", task.getException());
        }
    }
});