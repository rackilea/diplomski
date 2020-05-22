mQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            List<TaskItem> list = new ArrayList<>();
            for (DocumentSnapshot document : task.getResult()) {
                TaskItem taskItem = document.toObject(TaskItem.class);
                list.add(taskItem);
            }
            Log.d(TAG, list.toString());
        }
    }
});