FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
if (firebaseUser != null) {
    String uid = firebaseUser.getUid();
    rootRef.collection("users").document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
        @Override
        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    List<DocumentReference> list = (List<DocumentReference>) document.get("bookmarks");
                    List<Task<DocumentSnapshot>> tasks = new ArrayList<>();
                    for (DocumentReference documentReference : list) {
                        Task<DocumentSnapshot> documentSnapshotTask = documentReference.get();
                        tasks.add(documentSnapshotTask);
                    }
                    Tasks.whenAllSuccess(tasks).addOnSuccessListener(new OnSuccessListener<List<Object>>() {
                        @Override
                        public void onSuccess(List<Object> list) {
                            //Do what you need to do with your list
                            for (Object object : list) {
                                TeacherPojo tp = ((DocumentSnapshot) object).toObject(TeacherPojo.class);
                                Log.d("TAG", tp.getFirstName());
                            }
                        }
                    });
                }
            }
        }
    });
}