private void addMessagesEventListener(boolean firstTime) {
    CollectionReference messagesCollection = chatsCollection.document(chat.getId()).collection(Constants.FIREBASE_MESSAGES_PATH);
    Query query = messagesCollection.orderBy("timestamp", Query.Direction.DESCENDING);
    if (!firstTime) {
        query = query.startAt(startListen);
    }
    query.limit(20).get().addOnSuccessListener(queryDocumentSnapshots -> {
        if (!firstTime) {
            endListen = startListen;
        }
        startListen = queryDocumentSnapshots.getDocuments().get(queryDocumentSnapshots.size() - 1);

        Query innerQuery = messagesCollection.orderBy("timestamp").startAt(startListen);
        if(!firstTime) {
            innerQuery = innerQuery.endBefore(endListen);
        }
        ListenerRegistration listener = innerQuery
                .addSnapshotListener((queryDocumentSnapshots1, e) -> {
                    if (e != null) {
                        Log.w("SASA", "listen:error", e);
                        return;
                    }

                    for (DocumentChange dc : queryDocumentSnapshots1.getDocumentChanges()) {
                        Message message = dc.getDocument().toObject(Message.class);
                        switch (dc.getType()) {
                            case ADDED:
                                // add new message to list
                                messageListAdapter.addMessage(message);
                                if (firstTime) {
                                    messagesList.smoothScrollToPosition(0);
                                }
                                break;
                            case REMOVED:
                                // remove message from list
                                messageListAdapter.removeMessage(message);
                                break;
                        }
                    }
                });
        listeners.add(listener);
    });
}