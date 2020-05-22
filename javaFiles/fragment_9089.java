db.collection("forum_topics")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    if (task.isSuccessful()) {
                        int count = 0;
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            forumTopics.add(count, document.getString("topic_name"));
                            count += 1;
                             forumTopics.add(document.get("topic_name"));
                        }
                        forumAdapter.notifyDataSetChanged()
                    } else {
                        Log.d(TAG, "Error getting documents: ", task.getException());
                    }
                }
            });

    ListAdapter forumAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, forumTopics);
    ListView forumListView =  findViewById(R.id.ForumListView);
    forumListView.setAdapter(forumAdapter);