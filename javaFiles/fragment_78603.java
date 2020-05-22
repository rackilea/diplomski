FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
DocumentReference ref = rootRef.collection("Posts").document("Post");
ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                long numberOfLikes = document.getLong("Likes");
                Log.d(TAG, String.valueOf(numberOfLikes));
            } else {
                Log.d(TAG, "No such document");
            }
        } else {
            Log.d(TAG, "get failed with ", task.getException());
        }
    }
});