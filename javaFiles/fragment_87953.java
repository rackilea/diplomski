chats.addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(QuerySnapshot snapshot, FirebaseFirestoreException e) {

                    for (DocumentChange documentChange : snapshot.getDocumentChanges())
                    {
                        Object date =  documentChange.getDocument().getData().get("date");
                    }
                }