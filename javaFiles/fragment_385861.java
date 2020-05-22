db.collection("Posts").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            int count = 0;
            for (DocumentSnapshot document : task.getResult()) {
                count++;
            }
            Log.d("TAG", count + "");
        } else {
            Log.d(TAG, "Error getting documents: ", task.getException());
        }
    }
});