FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference usersRef = rootRef.collection("users");
Query query = usersRef.whereEqualTo("email", "student@email.com")
query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                String email = document.getString("email");
                String password = document.getString("password");
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(/* ... */);
            }
        }
    }
});