void getData() {
    db.collection("cities")
        .get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<MyData> list = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        list.add(new MyData(document.getData()));
                    }
                    processData(list);
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
}

void processData(List<MyData> data) {
    // do stuff with the data, or make a copy, or otherwise share it
    // with the rest of your program
}