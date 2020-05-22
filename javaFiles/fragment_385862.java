db.collection("Posts").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            Log.d("TAG", task.getResult().size() + "");
        } else {
            Log.d(TAG, "Error getting documents: ", task.getException());
        }
    }
});