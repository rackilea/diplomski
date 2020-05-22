FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference userPhotoRef = rootRef.collection("user_photos");
userPhotoRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            List<Photo> list = new ArrayList<>();
            for (DocumentSnapshot document : task.getResult()) {
                Log.d(TAG, document.getId() + " => " + document.getData());

                if (document.exists()) {
                    Photo photo = document.toObject(Photo.class);
                    list.add(photo); //Add Photo object to the list
                }

                //Do what you need to do with your list
            }
        } else {
            Log.d(TAG, "Error getting documents: ", task.getException());
        }
    }
});