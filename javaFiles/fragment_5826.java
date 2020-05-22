String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference usersRef = rootRef.collection("users");
usersRef.document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                Map<String, Object> map = document.getData();
            }
        }
    }
});