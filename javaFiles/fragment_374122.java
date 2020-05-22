mDocumentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                //Get an object of type UserPOJO
                UserPOJO pojo = document.toObject(UserPOJO.class);
            }
        }
    }
});