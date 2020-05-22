String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DocumentReference dataRef = db.collection("users").document(uid);
dataRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
    @Override
    public void onSuccess(DocumentSnapshot documentSnapshot) {
        User user = documentSnapshot.toObject(User.class);
        Log.d(TAG, user.getFullname());
    }
});