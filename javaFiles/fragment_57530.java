CollectionReference questionRef = firebaseFirestore.collection("questions");
questionRef.whereEqualTo("number", "20").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
    @Override
    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
        questionObject pContent = queryDocumentSnapshots.toObjects(questionObject.class);
    }
});