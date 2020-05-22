FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference collRef = rootRef.collection("yourCollection");
List<String> myGroupTags = new ArrayList<>();
List<DocumentReference> listDocRef = new ArrayList<>();
for(String s : myGroupTags) {
    DocumentReference docRef = collRef.document(s);
    listDocRef.add(docRef);
}

List<Task<DocumentSnapshot>> tasks = new ArrayList<>();
for (DocumentReference documentReference : listDocRef) {
    Task<DocumentSnapshot> documentSnapshotTask = documentReference.get();
    tasks.add(documentSnapshotTask);
}
Tasks.whenAllSuccess(tasks).addOnSuccessListener(new OnSuccessListener<List<Object>>() {
    @Override
    public void onSuccess(List<Object> list) {
        //Do what you need to do with your list
        for (Object object : list) {
            GroupBase gb = ((DocumentSnapshot) object).toObject(GroupBase.class);
            Log.d("TAG", tp.getPropertyname);
        }
    }
});