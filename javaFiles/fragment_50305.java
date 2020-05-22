void getData() {
    final List<MyData> list = new ArrayList<>();

    db.collection("cities")
        .get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        list.add(new MyData(document.getData()));
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });

    Log.d(TAG, "List size = " + list.size()); // will print 0
    // list will be empty here, the firebase call will take hundreds 
    // to thousands of milliseconds to complete
}