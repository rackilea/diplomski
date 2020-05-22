public static ArrayList<NoteFB> getNotes() {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    final String TAG = "FB Adapter";

    final ArrayList<NoteFB> doFBs = new ArrayList<>();

    try {
        Task<QuerySnapshot> taskResult = Tasks.await(db.collection("notesItem").get(), 2, TimeUnit.SECONDS)
        for (QueryDocumentSnapshot document : task.getResult()) {
            Log.d(TAG, document.getId() + " => " + document.getData());
            doFBs.add(document.toObject(NoteFB.class));
         }

    } catch(Exception e) {
         Log.w(TAG, "Error getting documents.", e.localizedString());
    }
    return doFBs
}