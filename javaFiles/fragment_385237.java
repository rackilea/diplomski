FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference tasksRef = rootRef.collection("tasks");
tasksRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            List<Task> taskList = new ArrayList<>();
            List<String> keys = new ArrayList<>();
            for (QueryDocumentSnapshot document : task.getResult()) {
                Task t = document.toObject(Task.class);
                taskList.add(t);
                String key = document.getId();
                keys.add(key);
            }

            //Create/notify the adapter
        }
    }
});