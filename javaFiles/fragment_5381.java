hindiStoryref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.getResult() != null && task.getResult().exists() && task.getResult().getData() != null) {
                    list.addAll(task.getResult().getData().keySet()); //Adding list of field list into list object
                    Log.d("arrayKeys size", list.size() + "");
                    Log.d("arrayKeys size", list.toString());
                }
            }
        });