FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference questionsRef = rootRef.collection("questions");
questionsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (DocumentSnapshot document : task.getResult()) {
                Qst qst = document.toObject(Qst.class);
                Log.d("TAG", qst.getQst());
            }
        }
    }
});