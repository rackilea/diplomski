rootRef.collection("facultades").document("3QE27w19sttNvx1sGoqR").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                List<Object> list = (List<Object>) document.get("escuelas");
                //Iterate throught the list and get the data
            }
        }
    }
});