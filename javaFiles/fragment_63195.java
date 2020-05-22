db.collection("cities")
    .whereEqualTo("state", "CA")
    .addSnapshotListener(new EventListener<QuerySnapshot>() {
        @Override
        public void onEvent(@Nullable QuerySnapshot snapshots,
                @Nullable FirebaseFirestoreException e) {
        if (e != null) {
            Log.w(TAG, "listen:error", e);
            return;
        }

        for (DocumentChange dc : snapshots.getDocumentChanges()) {
            switch (dc.getType()) {
            case ADDED:
                Log.d(TAG, "New city: " + dc.getDocument().getData());
                break;
            case MODIFIED:
                Log.d(TAG, "Modified city: " + dc.getDocument().getData());
                break;
            case REMOVED:
                Log.d(TAG, "Removed city: " + dc.getDocument().getData());
                break;
            }
        }

        }
    });