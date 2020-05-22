private void updateBook1() {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference bookRef = db.collection("Book").document(id); // ID got from the Intent Extras

}