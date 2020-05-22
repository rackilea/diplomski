FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
rootRef.collection("CodeClinic").document("Codes").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                String clinica = document.getString("Clinica");
                Long feup = document.getLong("FEUP");
                String outra = document.getString("outra");
                Log.d("TAG", clinica + " / " + feup + " / " + outra);
            }
        }
    }
});